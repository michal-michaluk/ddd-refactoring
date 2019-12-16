package shortage.prediciton;

import entities.DemandEntity;
import enums.DeliverySchema;
import tools.Util;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demands {

    private final Map<LocalDate, DemandEntity> demandsPerDay;

    public Demands(List<DemandEntity> demands) {
        demandsPerDay = new HashMap<>();
        for (DemandEntity demand1 : demands) {
            demandsPerDay.put(demand1.getDay(), demand1);
        }
    }

    public Demand get(LocalDate day) {
        if (demandsPerDay.containsKey(day)) {
            return new Demand(demandsPerDay.get(day));
        } else {
            return null;
        }
    }

    public static class Demand {
        private final DemandEntity demand;

        public Demand(DemandEntity demand) {
            this.demand = demand;
        }

        public boolean hasDeliverySchema(DeliverySchema schema) {
            return Util.getDeliverySchema(demand) == schema;
        }

        public long getLevel() {
            return Util.getLevel(demand);
        }
    }
}
