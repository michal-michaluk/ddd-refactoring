package external;

public class CurrentStock {
    private long level;
    private long locked;

    public CurrentStock(long level, long locked) {
        this.level = level;
        this.locked = locked;
    }

    public long getLevel() {
        return this.level;
    }

    public long getLocked() {
        return this.locked;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof CurrentStock)) return false;
        final CurrentStock other = (CurrentStock) o;
        if (this.getLevel() != other.getLevel()) return false;
        if (this.getLocked() != other.getLocked()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $level = this.getLevel();
        result = result * PRIME + (int) ($level >>> 32 ^ $level);
        final long $locked = this.getLocked();
        result = result * PRIME + (int) ($locked >>> 32 ^ $locked);
        return result;
    }

    public String toString() {
        return "external.CurrentStock(level=" + this.getLevel() + ", locked=" + this.getLocked() + ")";
    }
}
