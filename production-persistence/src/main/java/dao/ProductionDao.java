package dao;

import entities.ProductionEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by michal on 07.03.2017.
 */
public interface ProductionDao {
    ProductionEntity get(long id);

    List<ProductionEntity> findFromTime(String productRefNo, LocalDateTime start);

    List<ProductionEntity> findFromTime(long id, LocalDateTime start);

    void save(ProductionEntity production);
}
