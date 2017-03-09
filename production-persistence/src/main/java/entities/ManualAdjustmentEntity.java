package entities;


import enums.DeliverySchema;

/**
 * Created by michal on 07.03.2017.
 */
//Entity
public class ManualAdjustmentEntity {
    private long level;
    private String note;
    private DeliverySchema deliverySchema;

    public ManualAdjustmentEntity() {
    }

    public long getLevel() {
        return this.level;
    }

    public String getNote() {
        return this.note;
    }

    public DeliverySchema getDeliverySchema() {
        return this.deliverySchema;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDeliverySchema(DeliverySchema deliverySchema) {
        this.deliverySchema = deliverySchema;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ManualAdjustmentEntity)) return false;
        final ManualAdjustmentEntity other = (ManualAdjustmentEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getLevel() != other.getLevel()) return false;
        final Object this$note = this.getNote();
        final Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) return false;
        final Object this$deliverySchema = this.getDeliverySchema();
        final Object other$deliverySchema = other.getDeliverySchema();
        if (this$deliverySchema == null ? other$deliverySchema != null : !this$deliverySchema.equals(other$deliverySchema))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $level = this.getLevel();
        result = result * PRIME + (int) ($level >>> 32 ^ $level);
        final Object $note = this.getNote();
        result = result * PRIME + ($note == null ? 43 : $note.hashCode());
        final Object $deliverySchema = this.getDeliverySchema();
        result = result * PRIME + ($deliverySchema == null ? 43 : $deliverySchema.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ManualAdjustmentEntity;
    }

    public String toString() {
        return "entities.ManualAdjustmentEntity(level=" + this.getLevel() + ", note=" + this.getNote() + ", deliverySchema=" + this.getDeliverySchema() + ")";
    }
}
