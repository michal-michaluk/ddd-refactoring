package api;

import enums.DeliverySchema;

import java.time.LocalDate;

public class AdjustDemandDto {
    private String productRefNo;
    private LocalDate atDay;
    private long level;
    private DeliverySchema deliverySchema;
    private String note;

    public AdjustDemandDto() {
    }

    public String getProductRefNo() {
        return this.productRefNo;
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

    public String getNote() {
        return this.note;
    }

    public void setProductRefNo(String productRefNo) {
        this.productRefNo = productRefNo;
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

    public void setNote(String note) {
        this.note = note;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof AdjustDemandDto)) return false;
        final AdjustDemandDto other = (AdjustDemandDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$productRefNo = this.getProductRefNo();
        final Object other$productRefNo = other.getProductRefNo();
        if (this$productRefNo == null ? other$productRefNo != null : !this$productRefNo.equals(other$productRefNo))
            return false;
        final Object this$atDay = this.getAtDay();
        final Object other$atDay = other.getAtDay();
        if (this$atDay == null ? other$atDay != null : !this$atDay.equals(other$atDay)) return false;
        if (this.getLevel() != other.getLevel()) return false;
        final Object this$deliverySchema = this.getDeliverySchema();
        final Object other$deliverySchema = other.getDeliverySchema();
        if (this$deliverySchema == null ? other$deliverySchema != null : !this$deliverySchema.equals(other$deliverySchema))
            return false;
        final Object this$note = this.getNote();
        final Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $productRefNo = this.getProductRefNo();
        result = result * PRIME + ($productRefNo == null ? 43 : $productRefNo.hashCode());
        final Object $atDay = this.getAtDay();
        result = result * PRIME + ($atDay == null ? 43 : $atDay.hashCode());
        final long $level = this.getLevel();
        result = result * PRIME + (int) ($level >>> 32 ^ $level);
        final Object $deliverySchema = this.getDeliverySchema();
        result = result * PRIME + ($deliverySchema == null ? 43 : $deliverySchema.hashCode());
        final Object $note = this.getNote();
        result = result * PRIME + ($note == null ? 43 : $note.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AdjustDemandDto;
    }

    public String toString() {
        return "api.AdjustDemandDto(productRefNo=" + this.getProductRefNo() + ", atDay=" + this.getAtDay() + ", level=" + this.getLevel() + ", deliverySchema=" + this.getDeliverySchema() + ", note=" + this.getNote() + ")";
    }
}
