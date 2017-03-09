package api;

public interface LogisticService {

    void adjustDemand(AdjustDemandDto adjustment);

    void processCallof(Object document);

    StockForecastDto getStockForecast(String productRefNo);
}
