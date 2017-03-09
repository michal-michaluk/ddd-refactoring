package api;


public class StorageUnit {
    private String productRefNo;
    private long amount;

    public StorageUnit() {
    }

    public String getProductRefNo() {
        return this.productRefNo;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setProductRefNo(String productRefNo) {
        this.productRefNo = productRefNo;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof StorageUnit)) return false;
        final StorageUnit other = (StorageUnit) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$productRefNo = this.getProductRefNo();
        final Object other$productRefNo = other.getProductRefNo();
        if (this$productRefNo == null ? other$productRefNo != null : !this$productRefNo.equals(other$productRefNo))
            return false;
        if (this.getAmount() != other.getAmount()) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $productRefNo = this.getProductRefNo();
        result = result * PRIME + ($productRefNo == null ? 43 : $productRefNo.hashCode());
        final long $amount = this.getAmount();
        result = result * PRIME + (int) ($amount >>> 32 ^ $amount);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof StorageUnit;
    }

    public String toString() {
        return "api.StorageUnit(productRefNo=" + this.getProductRefNo() + ", amount=" + this.getAmount() + ")";
    }
}
