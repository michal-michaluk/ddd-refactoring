package tools;

import entities.ProductionEntity;
import shortage.prediciton.ProductionOutputs;

import java.util.List;

public class ProductionOutputsFactory {
    private final List<ProductionEntity> productions;

    public ProductionOutputsFactory(List<ProductionEntity> productions) {
        this.productions = productions;
    }

    public ProductionOutputs createProductionOutputs() {
        return new ProductionOutputs(productions);
    }
}
