package tools;

import entities.DemandEntity;
import shortage.prediciton.Demands;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemandsFactory {
    private final List<DemandEntity> demands;

    public DemandsFactory(List<DemandEntity> demands) {
        this.demands = demands;
    }

    public Demands createDemands() {
        Map<LocalDate, Demands.Demand> demandsPerDay = demands.stream()
                .collect(Collectors.toMap(
                        DemandEntity::getDay,
                        demand -> new Demands.Demand(
                                Util.getDeliverySchema(demand),
                                Util.getLevel(demand))
                ));

        return new Demands(demandsPerDay);
    }
}
