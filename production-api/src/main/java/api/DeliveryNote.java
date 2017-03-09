package api;

import java.util.List;

public class DeliveryNote {
    private List<String> products;

    public DeliveryNote() {
    }

    public List<String> getProducts() {
        return this.products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof DeliveryNote)) return false;
        final DeliveryNote other = (DeliveryNote) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$products = this.getProducts();
        final Object other$products = other.getProducts();
        if (this$products == null ? other$products != null : !this$products.equals(other$products)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $products = this.getProducts();
        result = result * PRIME + ($products == null ? 43 : $products.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof DeliveryNote;
    }

    public String toString() {
        return "api.DeliveryNote(products=" + this.getProducts() + ")";
    }
}
