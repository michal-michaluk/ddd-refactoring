package shortage.prediciton;

import enums.DeliverySchema;

import java.time.LocalDate;
import java.util.Map;

public class Demands {

    private final Map<LocalDate, Demand> demandsPerDay;

    public Demands(Map<LocalDate, Demand> demandsPerDay) {
        this.demandsPerDay = demandsPerDay;
    }

    public Demand get(LocalDate day) {
        return demandsPerDay.getOrDefault(day, null);
    }

    public static class Demand {
        private final long level;
        private final DeliverySchema deliverySchema;

        public Demand(DeliverySchema deliverySchema, long level) {
            this.deliverySchema = deliverySchema;
            this.level = level;
        }

        public boolean hasDeliverySchema(DeliverySchema schema) {
            return deliverySchema == schema;
        }

        public long getLevel() {
            return level;
        }
    }
}
