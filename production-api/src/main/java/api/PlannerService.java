package api;

import java.time.Duration;
import java.time.LocalDateTime;

public interface PlannerService {

    void scheduleNewProduction(long lineId, long formId, LocalDateTime start, Duration duration);

    void adjustProductionTime(long productionId, LocalDateTime start, Duration duration);

    void setColor(long productionId, String color);

    void setNote(long productionId, String note);

    PlanViewDto getPlan(long line);
}
