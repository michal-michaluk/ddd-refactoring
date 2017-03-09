package tools;

import entities.DemandEntity;
import entities.FormEntity;
import entities.LineEntity;
import enums.DeliverySchema;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by michal on 07.03.2017.
 */
public class Util {

    private Util() {
    }

    public static long getLevel(DemandEntity demand) {
        if (demand.getAdjustment().isEmpty()) {
            return demand.getOriginal().getLevel();
        } else {
            return demand.getAdjustment().get(demand.getAdjustment().size() - 1).getLevel();
        }
    }

    public static DeliverySchema getDeliverySchema(DemandEntity demand) {
        DeliverySchema deliverySchema;
        if (demand.getAdjustment().isEmpty()) {
            deliverySchema = demand.getOriginal().getDeliverySchema();
        } else {
            deliverySchema = demand.getAdjustment().get(demand.getAdjustment().size() - 1).getDeliverySchema();
        }
        if (deliverySchema == null) {
            return defaultFor(demand.getProductRefNo());
        }
        return deliverySchema;
    }

    /**
     * <pre>
     * Rules for   Default Delivery Schema:
     * If delivery scheme is not defined in callof document, we apply following rules:
     *  Product refNo: 461952387712 and 461952816051 are delivered every 3 hours during day shifts every day.
     *   All products for customer „Pralki Wir” (refNo starts with 51) need to be delivered till end of production day.
     *  There is no need to produce other products just in time so we can treat them as delivery at start of production day.
     * </pre>
     */
    private static DeliverySchema defaultFor(String productRefNo) {
        if (productRefNo.equals("461952387712") || productRefNo.equals("461952816051")) {
            return DeliverySchema.every3hours;
        }
        if (productRefNo.startsWith("51")) {
            return DeliverySchema.tillEndOfDay;
        }
        return DeliverySchema.atDayStart;
    }

    public static boolean isFormAvailableAt(FormEntity form, LocalDateTime start, Duration duration) {
        // TODO How to store / calculate that ?
        return false;
    }

    public static boolean canProduceOn(LineEntity line, FormEntity form) {
        return line.getMaxWeight() > form.getWeight();
    }

}
