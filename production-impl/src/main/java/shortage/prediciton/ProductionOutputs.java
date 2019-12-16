package shortage.prediciton;

import entities.ProductionEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductionOutputs {
    private String productRefNo = null;
    private final Map<LocalDate, ProductionEntity> outputs;

    public ProductionOutputs(List<ProductionEntity> productions) {
        outputs = new HashMap<>();
        for (ProductionEntity production : productions) {
            outputs.put(production.getStart().toLocalDate(), production);
            productRefNo = production.getForm().getRefNo();
        }
    }

    public long get(LocalDate day) {
        ProductionEntity production = outputs.get(day);
        if (production != null) {
            return production.getOutput();
        } else {
            return 0;
        }
    }

    public String getProductRefNo() {
        return productRefNo;
    }
}
