package tools;

import entities.DemandEntity;
import shortage.prediciton.Demands;

import java.util.List;

public class DemandsFactory {
    private final List<DemandEntity> demands;

    public DemandsFactory(List<DemandEntity> demands) {
        this.demands = demands;
    }

    public Demands createDemands() {
        return new Demands(demands);
    }
}
