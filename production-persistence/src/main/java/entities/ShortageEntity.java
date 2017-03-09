package entities;

import java.time.LocalDate;

/**
 * Created by michal on 07.03.2017.
 */
//Entity
public class ShortageEntity {
    private String refNo;
    private LocalDate found;
    private long missing;
    private LocalDate atDay;

    public ShortageEntity() {
    }

    public String getRefNo() {
        return this.refNo;
    }

    public LocalDate getFound() {
        return this.found;
    }

    public long getMissing() {
        return this.missing;
    }

    public LocalDate getAtDay() {
        return this.atDay;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public void setFound(LocalDate found) {
        this.found = found;
    }

    public void setMissing(long missing) {
        this.missing = missing;
    }

    public void setAtDay(LocalDate atDay) {
        this.atDay = atDay;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ShortageEntity)) return false;
        final ShortageEntity other = (ShortageEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$refNo = this.getRefNo();
        final Object other$refNo = other.getRefNo();
        if (this$refNo == null ? other$refNo != null : !this$refNo.equals(other$refNo)) return false;
        final Object this$found = this.getFound();
        final Object other$found = other.getFound();
        if (this$found == null ? other$found != null : !this$found.equals(other$found)) return false;
        if (this.getMissing() != other.getMissing()) return false;
        final Object this$atDay = this.getAtDay();
        final Object other$atDay = other.getAtDay();
        if (this$atDay == null ? other$atDay != null : !this$atDay.equals(other$atDay)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $refNo = this.getRefNo();
        result = result * PRIME + ($refNo == null ? 43 : $refNo.hashCode());
        final Object $found = this.getFound();
        result = result * PRIME + ($found == null ? 43 : $found.hashCode());
        final long $missing = this.getMissing();
        result = result * PRIME + (int) ($missing >>> 32 ^ $missing);
        final Object $atDay = this.getAtDay();
        result = result * PRIME + ($atDay == null ? 43 : $atDay.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ShortageEntity;
    }

    public String toString() {
        return "entities.ShortageEntity(refNo=" + this.getRefNo() + ", found=" + this.getFound() + ", missing=" + this.getMissing() + ", atDay=" + this.getAtDay() + ")";
    }
}
