package dao;

import entities.FormEntity;

/**
 * Created by michal on 07.03.2017.
 */
public interface FormDao {
    FormEntity find(long formId);
}
