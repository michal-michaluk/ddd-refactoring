package dao;

import entities.LineEntity;

/**
 * Created by michal on 07.03.2017.
 */
public interface LineDao {
    LineEntity find(long lineId);
}
