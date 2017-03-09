package entities;

/**
 * Created by michal on 31.12.2016.
 */
//Entity
public class LineEntity {

    private long id;
    private double maxWeight;

    public LineEntity() {
    }

    public long getId() {
        return this.id;
    }

    public double getMaxWeight() {
        return this.maxWeight;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof LineEntity)) return false;
        final LineEntity other = (LineEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        if (Double.compare(this.getMaxWeight(), other.getMaxWeight()) != 0) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final long $maxWeight = Double.doubleToLongBits(this.getMaxWeight());
        result = result * PRIME + (int) ($maxWeight >>> 32 ^ $maxWeight);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof LineEntity;
    }

    public String toString() {
        return "entities.LineEntity(id=" + this.getId() + ", maxWeight=" + this.getMaxWeight() + ")";
    }
}
