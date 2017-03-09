package entities;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 01.02.2017.
 */
//Entity
public class DemandEntity {

    private long id;
    private LocalDate callofDate;
    private String productRefNo;
    private LocalDate atDay;
    private OriginalDemandEntity original;
    private List<ManualAdjustmentEntity> adjustment = new LinkedList<>();

    public DemandEntity() {
    }

    public long getId() {
        return this.id;
    }

    public LocalDate getCallofDate() {
        return this.callofDate;
    }

    public String getProductRefNo() {
        return this.productRefNo;
    }

    public LocalDate getDay() {
        return this.atDay;
    }

    public OriginalDemandEntity getOriginal() {
        return this.original;
    }

    public List<ManualAdjustmentEntity> getAdjustment() {
        return this.adjustment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCallofDate(LocalDate callofDate) {
        this.callofDate = callofDate;
    }

    public void setProductRefNo(String productRefNo) {
        this.productRefNo = productRefNo;
    }

    public void setAtDay(LocalDate atDay) {
        this.atDay = atDay;
    }

    public void setOriginal(OriginalDemandEntity original) {
        this.original = original;
    }

    public void setAdjustment(List<ManualAdjustmentEntity> adjustment) {
        this.adjustment = adjustment;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof DemandEntity)) return false;
        final DemandEntity other = (DemandEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$callofDate = this.getCallofDate();
        final Object other$callofDate = other.getCallofDate();
        if (this$callofDate == null ? other$callofDate != null : !this$callofDate.equals(other$callofDate))
            return false;
        final Object this$productRefNo = this.getProductRefNo();
        final Object other$productRefNo = other.getProductRefNo();
        if (this$productRefNo == null ? other$productRefNo != null : !this$productRefNo.equals(other$productRefNo))
            return false;
        final Object this$atDay = this.getDay();
        final Object other$atDay = other.getDay();
        if (this$atDay == null ? other$atDay != null : !this$atDay.equals(other$atDay)) return false;
        final Object this$original = this.getOriginal();
        final Object other$original = other.getOriginal();
        if (this$original == null ? other$original != null : !this$original.equals(other$original)) return false;
        final Object this$adjustment = this.getAdjustment();
        final Object other$adjustment = other.getAdjustment();
        if (this$adjustment == null ? other$adjustment != null : !this$adjustment.equals(other$adjustment))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $callofDate = this.getCallofDate();
        result = result * PRIME + ($callofDate == null ? 43 : $callofDate.hashCode());
        final Object $productRefNo = this.getProductRefNo();
        result = result * PRIME + ($productRefNo == null ? 43 : $productRefNo.hashCode());
        final Object $atDay = this.getDay();
        result = result * PRIME + ($atDay == null ? 43 : $atDay.hashCode());
        final Object $original = this.getOriginal();
        result = result * PRIME + ($original == null ? 43 : $original.hashCode());
        final Object $adjustment = this.getAdjustment();
        result = result * PRIME + ($adjustment == null ? 43 : $adjustment.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof DemandEntity;
    }

    public String toString() {
        return "entities.DemandEntity(id=" + this.getId() + ", callofDate=" + this.getCallofDate() + ", productRefNo=" + this.getProductRefNo() + ", atDay=" + this.getDay() + ", original=" + this.getOriginal() + ", adjustment=" + this.getAdjustment() + ")";
    }

}
