package entities;

import java.time.Duration;

/**
 * Created by michal on 31.12.2016.
 */
//Entity
public class FormEntity {

    private String refNo;
    private double outputPerMinute;
    private double utilization;
    private double weight;
    private Duration startAndWormUp;
    private Duration endAndCleaning;

    public FormEntity() {
    }

    public String getRefNo() {
        return this.refNo;
    }

    public double getOutputPerMinute() {
        return this.outputPerMinute;
    }

    public double getUtilization() {
        return this.utilization;
    }

    public double getWeight() {
        return this.weight;
    }

    public Duration getStartAndWormUp() {
        return this.startAndWormUp;
    }

    public Duration getEndAndCleaning() {
        return this.endAndCleaning;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public void setOutputPerMinute(double outputPerMinute) {
        this.outputPerMinute = outputPerMinute;
    }

    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStartAndWormUp(Duration startAndWormUp) {
        this.startAndWormUp = startAndWormUp;
    }

    public void setEndAndCleaning(Duration endAndCleaning) {
        this.endAndCleaning = endAndCleaning;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof FormEntity)) return false;
        final FormEntity other = (FormEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$refNo = this.getRefNo();
        final Object other$refNo = other.getRefNo();
        if (this$refNo == null ? other$refNo != null : !this$refNo.equals(other$refNo)) return false;
        if (Double.compare(this.getOutputPerMinute(), other.getOutputPerMinute()) != 0) return false;
        if (Double.compare(this.getUtilization(), other.getUtilization()) != 0) return false;
        if (Double.compare(this.getWeight(), other.getWeight()) != 0) return false;
        final Object this$startAndWormUp = this.getStartAndWormUp();
        final Object other$startAndWormUp = other.getStartAndWormUp();
        if (this$startAndWormUp == null ? other$startAndWormUp != null : !this$startAndWormUp.equals(other$startAndWormUp))
            return false;
        final Object this$endAndCleaning = this.getEndAndCleaning();
        final Object other$endAndCleaning = other.getEndAndCleaning();
        if (this$endAndCleaning == null ? other$endAndCleaning != null : !this$endAndCleaning.equals(other$endAndCleaning))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $refNo = this.getRefNo();
        result = result * PRIME + ($refNo == null ? 43 : $refNo.hashCode());
        final long $outputPerMinute = Double.doubleToLongBits(this.getOutputPerMinute());
        result = result * PRIME + (int) ($outputPerMinute >>> 32 ^ $outputPerMinute);
        final long $utilization = Double.doubleToLongBits(this.getUtilization());
        result = result * PRIME + (int) ($utilization >>> 32 ^ $utilization);
        final long $weight = Double.doubleToLongBits(this.getWeight());
        result = result * PRIME + (int) ($weight >>> 32 ^ $weight);
        final Object $startAndWormUp = this.getStartAndWormUp();
        result = result * PRIME + ($startAndWormUp == null ? 43 : $startAndWormUp.hashCode());
        final Object $endAndCleaning = this.getEndAndCleaning();
        result = result * PRIME + ($endAndCleaning == null ? 43 : $endAndCleaning.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof FormEntity;
    }

    public String toString() {
        return "entities.FormEntity(refNo=" + this.getRefNo() + ", outputPerMinute=" + this.getOutputPerMinute() + ", utilization=" + this.getUtilization() + ", weight=" + this.getWeight() + ", startAndWormUp=" + this.getStartAndWormUp() + ", endAndCleaning=" + this.getEndAndCleaning() + ")";
    }
}
