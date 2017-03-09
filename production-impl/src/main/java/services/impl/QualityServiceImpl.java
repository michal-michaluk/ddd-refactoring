package services.impl;

import api.QualityService;
import api.StorageUnit;
import dao.DemandDao;
import dao.ProductionDao;
import dao.ShortageDao;
import entities.ShortageEntity;
import external.CurrentStock;
import external.JiraService;
import external.NotificationsService;
import external.StockService;
import tools.ShortageFinder;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

public class QualityServiceImpl implements QualityService {

    //Inject all
    private ShortageDao shortageDao;
    private ProductionDao productionDao;
    private StockService stockService;
    private DemandDao demandDao;

    private NotificationsService notificationService;
    private JiraService jiraService;
    private Clock clock;

    private int confShortagePredictionDaysAhead;
    private long confIncreaseQATaskPriorityInDays;

    /**
     * <pre>
     *  Lock all parts from storage unit on stock.
     *  parts from storage unit are locked on stock
     *  If locking parts can lead to insufficient stock for next deliveries,
     *    parts recovery should have high priority.
     *  If there is a potential shortage in particular days,
     *    we need to rise an soft notification to planner.
     *  </pre>
     */
    //Transactional
    @Override
    public void lock(StorageUnit unit) {
        processShortages(unit.getProductRefNo());
    }

    /**
     * <pre>
     *  Unlock storage unit, recover X parts, Y parts was scrapped.
     *  stock.unlock(storageUnit, recovered, scrapped)
     *  Recovered parts are back on stock.
     *  Scrapped parts are removed from stock.
     *  If demand is not fulfilled by current product stock and production forecast
     *    there is a shortage in particular days and we need to rise an alert.
     * </pre>
     */
    //Transactional
    @Override
    public void unlock(StorageUnit unit, long recovered, long scrapped) {
        processShortages(unit.getProductRefNo());
    }

    public void processShortages(String productRefNo) {
        LocalDate today = LocalDate.now(clock);
        CurrentStock currentStock = stockService.getCurrentStock(productRefNo);
        List<ShortageEntity> shortages = ShortageFinder.findShortages(
                today, confShortagePredictionDaysAhead,
                currentStock,
                productionDao.findFromTime(productRefNo, today.atStartOfDay()),
                demandDao.findFrom(today.atStartOfDay(), productRefNo)
        );

        List<ShortageEntity> previous = shortageDao.getForProduct(productRefNo);
        if (!shortages.isEmpty() && !shortages.equals(previous)) {
            notificationService.softNotifyPlanner(shortages);
            if (currentStock.getLocked() > 0 &&
                    shortages.get(0).getAtDay()
                            .isBefore(today.plusDays(confIncreaseQATaskPriorityInDays))) {
                jiraService.increasePriorityFor(productRefNo);
            }
        }
        if (shortages.isEmpty() && !previous.isEmpty()) {
            shortageDao.delete(productRefNo);
        }
    }
}
