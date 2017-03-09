package services.impl;

import api.PlanViewDto;
import api.PlannerService;
import dao.*;
import entities.FormEntity;
import entities.LineEntity;
import entities.ProductionEntity;
import entities.ShortageEntity;
import external.CurrentStock;
import external.JiraService;
import external.NotificationsService;
import external.StockService;
import tools.ShortageFinder;
import tools.Util;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class PlannerServiceImpl implements PlannerService {

    //Inject all
    private ProductionDao productionDao;
    private LineDao lineDao;
    private FormDao formDao;
    private ShortageDao shortageDao;
    private StockService stockService;
    private DemandDao demandDao;

    private NotificationsService notificationService;
    private JiraService jiraService;
    private Clock clock;

    private int confShortagePredictionDaysAhead;
    private long confIncreaseQATaskPriorityInDays;

    /**
     * <pre>
     * Schedule new production on line, using form, at time for duration:
     *  Only if form will be available at the time for whole duration, production may by planned.
     *  Production includes retooling time, parts output of used form and utilization of human resources
     *      on that production stage.
     *  If production on given line overlaps with other: preceding must shrink,
     *                                                   succeeding one must start later.
     *  If consecutive productions use same from, retooling time between is zero.
     *  Production forecasts (parts output * production duration) changes new and changed productions.
     *  Overall utilization of human resources increases.
     *  Shortages may arise if insufficient production was planned.
     * </pre>
     */
    //Transactional
    @Override
    public void scheduleNewProduction(long lineId, long formId, LocalDateTime start, Duration duration) {
        LineEntity line = lineDao.find(lineId);
        FormEntity form = formDao.find(formId);

        if (!Util.canProduceOn(line, form)) {
            // TODO Ask: what in that case ?
        }
        if (!Util.isFormAvailableAt(form, start, duration)) {
            // TODO Ask: what in that case ?
        }
        List<ProductionEntity> currentlyPlanned = productionDao.findFromTime(line.getId(), start);

        // If preceding production use same from, retooling time between is zero.
        ProductionEntity preceding = null;
        Duration startDuration = Duration.ofMinutes(0);
        if (currentlyPlanned.size() > 0) {
            ProductionEntity first = currentlyPlanned.get(0);
            if (first.getStart().isBefore(start)) {
                preceding = first;
                if (!first.getForm().equals(form)) {
                    startDuration = form.getStartAndWormUp();
                }
            }
        }
        // If next production use same from, retooling time between is zero.
        Duration cleanDuration = Duration.ofMinutes(0);
        for (ProductionEntity next : currentlyPlanned) {
            if (next.getStart().isAfter(start) || next.getStart().isEqual(start)) {
                if (!next.getForm().equals(form)) {
                    cleanDuration = form.getEndAndCleaning();
                }
                break;
            }
        }
        List<ProductionEntity> changed = makeSpace(preceding, currentlyPlanned, start, duration);

        // Production forecasts (parts output * production duration) changes new and changed productions.
        // Overall utilization of human resources increases. 
        long output = (long) (form.getOutputPerMinute() * 1.0 * duration
                .minus(startDuration).minus(cleanDuration).toMinutes());
        double utilization = form.getUtilization() * 1.0;

        ProductionEntity newScheduled = new ProductionEntity();
        newScheduled.setLine(line);
        newScheduled.setForm(form);
        newScheduled.setStart(start);
        newScheduled.setDuration(duration);
        newScheduled.setStartAndWormUp(startDuration);
        newScheduled.setEndAndCleaning(cleanDuration);
        newScheduled.setSpeed(1.0);
        newScheduled.setOutput(output);
        newScheduled.setUtilization(utilization);
        newScheduled.setColor("WHITE");

        productionDao.save(newScheduled);

        // Shortages may arise if insufficient production was planned.
        processShortages(changed);
    }

    /**
     * <pre>
     * Adjust production to time and duration:
     *  If production on given line overlaps with other: preceding must shrink,
     *                                                   succeeding one must start later.
     *  If consecutive productions use same from, retooling time between is zero.
     *  Production forecasts (parts output * production duration) changes for changed productions.
     *  Overall utilization of human resources may change.
     *  Shortages may arise if insufficient production was planned.
     * </pre>
     */
    //Transactional
    @Override
    public void adjustProductionTime(long productionId, LocalDateTime start, Duration duration) {
        ProductionEntity production = productionDao.get(productionId);
        FormEntity form = production.getForm();
        if (!Util.isFormAvailableAt(form, start, duration)) {
            // TODO Ask: what in that case ?
        }
        List<ProductionEntity> currentlyPlanned = productionDao.findFromTime(production.getLine().getId(), start);
        ProductionEntity preceding = null;
        if (currentlyPlanned.size() > 0) {
            ProductionEntity first = currentlyPlanned.get(0);
            if (first.getStart().isBefore(start)) {
                preceding = first;
            }
        }
        List<ProductionEntity> changed = makeSpace(preceding, currentlyPlanned, start, duration);
        production.setStart(start);
        production.setDuration(duration);

        // Shortages may arise if insufficient production was planned.
        processShortages(changed);
    }

    //Transactional
    @Override
    public void setColor(long productionId, String color) {
        // just sets color of production block on screen
        ProductionEntity production = productionDao.get(productionId);
        production.setColor(color);
    }

    //Transactional
    @Override
    public void setNote(long productionId, String note) {
        // adds planner note for shift manager or production engineer
        ProductionEntity production = productionDao.get(productionId);
        production.setColor(note);
    }

    //ReadOnly
    @Override
    public PlanViewDto getPlan(long line) {
        return new PlanViewDto();
    }

    public List<ProductionEntity> makeSpace(ProductionEntity preceding,
                                            List<ProductionEntity> currentlyPlanned,
                                            LocalDateTime start, Duration duration) {
        List<ProductionEntity> changed = new LinkedList<>();

        if (preceding != null && overlaps(preceding.getStart(), preceding.getDuration(), start, duration)) {
            // If production on given line overlaps with other: preceding must shrink
            preceding.setDuration(Duration.between(preceding.getStart(), start));
            changed.add(preceding);
        }
        LocalDateTime lastStart = start;
        Duration lastDuration = duration;
        for (ProductionEntity production : currentlyPlanned) {
            if (production == preceding) {
                continue;
            }
            if (overlaps(production.getStart(), production.getDuration(), lastStart, lastDuration)) {
                // If production on given line overlaps with other: *ALL* succeeding one must start later.
                production.setStart(lastStart.plus(lastDuration));
                lastStart = production.getStart();
                lastDuration = production.getDuration();
                changed.add(production);
            } else {
                break;
            }
        }
        return changed;
    }

    /**
     * overlaps if:
     * <pre>
     *  first.start is after second.start && first.start is before second.end
     *        | ---  first --- |
     *  | --- second --- |
     *
     *  second.start is after first.start && second.start is before first.end
     *  | ---  first --- |
     *        | --- second --- |
     * </pre>
     */
    private boolean overlaps(LocalDateTime start, Duration duration, LocalDateTime lastStart, Duration lastDuration) {
        LocalDateTime firstStart;
        Duration firstDuration;
        LocalDateTime secondStart;
        Duration secondDuration;
        if (start.isBefore(lastStart)) {
            firstStart = start;
            firstDuration = duration;
            secondStart = lastStart;
            secondDuration = lastDuration;
        } else {
            firstStart = lastStart;
            firstDuration = lastDuration;
            secondStart = start;
            secondDuration = duration;
        }

        return firstStart.isAfter(secondStart) && firstStart.isBefore(secondStart.plus(secondDuration)) ||
                secondStart.isAfter(firstStart) && secondStart.isBefore(firstStart.plus(firstDuration))
                ;
    }

    private void processShortages(List<ProductionEntity> products) {
        LocalDate today = LocalDate.now(clock);

        for (ProductionEntity production : products) {
            CurrentStock currentStock = stockService.getCurrentStock(production.getForm().getRefNo());
            List<ShortageEntity> shortages = ShortageFinder.findShortages(
                    today, confShortagePredictionDaysAhead,
                    currentStock,
                    productionDao.findFromTime(production.getForm().getRefNo(), today.atStartOfDay()),
                    demandDao.findFrom(today.atStartOfDay(), production.getForm().getRefNo())
            );
            List<ShortageEntity> previous = shortageDao.getForProduct(production.getForm().getRefNo());
            if (!shortages.isEmpty() && !shortages.equals(previous)) {
                notificationService.markOnPlan(shortages);
                if (currentStock.getLocked() > 0 &&
                        shortages.get(0).getAtDay()
                                .isBefore(today.plusDays(confIncreaseQATaskPriorityInDays))) {
                    jiraService.increasePriorityFor(production.getForm().getRefNo());
                }
                shortageDao.save(shortages);
            }
            if (shortages.isEmpty() && !previous.isEmpty()) {
                shortageDao.delete(production.getForm().getRefNo());
            }
        }
    }
}
