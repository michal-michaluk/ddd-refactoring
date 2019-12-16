package tools;

import entities.ProductionEntity;
import shortage.prediciton.ProductionOutputs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductionOutputsFactory {
    private final List<ProductionEntity> productions;

    public ProductionOutputsFactory(List<ProductionEntity> productions) {
        this.productions = productions;
    }

    public ProductionOutputs createProductionOutputs() {
        Map<LocalDate, Long> outputs = productions.stream()
                .collect(Collectors.groupingBy(
                        production -> production.getStart().toLocalDate(),
                        Collectors.summingLong(ProductionEntity::getOutput)
                ));

        String productRefNo = productions.stream()
                .map(production -> production.getForm().getRefNo())
                .findFirst()
                .orElse(null);
        return new ProductionOutputs(productRefNo, outputs);
    }
}
