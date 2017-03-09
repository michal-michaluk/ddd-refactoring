package entities;

import enums.DeliverySchema;

import java.time.LocalDate;

/**
 * Created by michal on 07.03.2017.
 */
//Entity
public class OriginalDemandEntity {

    private LocalDate atDay;
    private long level;
    private DeliverySchema deliverySchema;

    public OriginalDemandEntity() {
    }

    public LocalDate getAtDay() {
        return this.atDay;
    }

    public long getLevel() {
        return this.level;
    }

    public DeliverySchema getDeliverySchema() {
        return this.deliverySchema;
    }

    public void setAtDay(LocalDate atDay) {
        this.atDay = atDay;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public void setDeliverySchema(DeliverySchema deliverySchema) {
        this.deliverySchema = deliverySchema;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof OriginalDemandEntity)) return false;
        final OriginalDemandEntity other = (OriginalDemandEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$atDay = this.getAtDay();
        final Object other$atDay = other.getAtDay();
        if (this$atDay == null ? other$atDay != null : !this$atDay.equals(other$atDay)) return false;
        if (this.getLevel() != other.getLevel()) return false;
        final Object this$deliverySchema = this.getDeliverySchema();
        final Object other$deliverySchema = other.getDeliverySchema();
        if (this$deliverySchema == null ? other$deliverySchema != null : !this$deliverySchema.equals(other$deliverySchema))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $atDay = this.getAtDay();
        result = result * PRIME + ($atDay == null ? 43 : $atDay.hashCode());
        final long $level = this.getLevel();
        result = result * PRIME + (int) ($level >>> 32 ^ $level);
        final Object $deliverySchema = this.getDeliverySchema();
        result = result * PRIME + ($deliverySchema == null ? 43 : $deliverySchema.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof OriginalDemandEntity;
    }

    public String toString() {
        return "entities.OriginalDemandEntity(atDay=" + this.getAtDay() + ", level=" + this.getLevel() + ", deliverySchema=" + this.getDeliverySchema() + ")";
    }
}
