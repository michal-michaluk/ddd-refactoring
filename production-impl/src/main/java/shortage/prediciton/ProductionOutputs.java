package shortage.prediciton;

import java.time.LocalDate;
import java.util.Map;

public class ProductionOutputs {
    private final String productRefNo;
    private final Map<LocalDate, Long> outputs;

    public ProductionOutputs(String productRefNo, Map<LocalDate, Long> outputs) {
        this.productRefNo = productRefNo;
        this.outputs = outputs;
    }

    public long get(LocalDate day) {
        return outputs.getOrDefault(day, 0L);
    }

    public String getProductRefNo() {
        return productRefNo;
    }
}
