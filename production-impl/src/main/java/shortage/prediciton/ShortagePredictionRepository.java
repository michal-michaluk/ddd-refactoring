package shortage.prediciton;

import external.CurrentStock;
import tools.DemandsFactory;
import tools.ProductionOutputsFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ShortagePredictionRepository {
    private CurrentStock stock;
    private ProductionOutputsFactory productionOutputsFactory;
    private DemandsFactory demandsFactory;

    public ShortagePredictionRepository(CurrentStock stock, ProductionOutputsFactory productionOutputsFactory, DemandsFactory demandsFactory) {
        this.stock = stock;
        this.productionOutputsFactory = productionOutputsFactory;
        this.demandsFactory = demandsFactory;
    }

    public ShortagePredictionAlgo get(LocalDate today, int daysAhead) {
        List<LocalDate> dates = Stream.iterate(today, date -> date.plusDays(1))
                .limit(daysAhead)
                .collect(toList());

        ProductionOutputs outputs = productionOutputsFactory.createProductionOutputs();
        Demands demandsPerDay = demandsFactory.createDemands();

        return new ShortagePredictionAlgo(stock, dates, outputs, demandsPerDay);
    }
}
