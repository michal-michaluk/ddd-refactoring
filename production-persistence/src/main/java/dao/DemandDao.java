package dao;

import entities.DemandEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by michal on 01.02.2017.
 */
public interface DemandDao {
    DemandEntity getCurrent(String productRefNo, LocalDate atDay);

    DemandEntity get(LocalDate callofDate, String productRefNo, LocalDate atDay);

    List<DemandEntity> findFrom(LocalDateTime localDateTime, String productRefNo);
}
