package dao;

import entities.ShortageEntity;

import java.util.List;

/**
 * Created by michal on 07.03.2017.
 */
public interface ShortageDao {
    void save(List<ShortageEntity> shortages);

    List<ShortageEntity> getForProduct(String refNo);

    void delete(String productRefNo);
}
