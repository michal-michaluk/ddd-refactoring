package api;

public interface WarehouseService {

    void registerNew(StorageUnit unit);

    void deliver(DeliveryNote note);
}
