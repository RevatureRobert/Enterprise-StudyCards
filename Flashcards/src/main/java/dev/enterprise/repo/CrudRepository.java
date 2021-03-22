package dev.enterprise.repo;

import java.util.List;

/**
 * A DAO implementation for working with the models in the application.
 * @param <T>
 * @param <I>
 */
public interface CrudRepository <T,I>{
    int save(T t);
    int update(T t);
    T findById(I i);
    List<T> findAll();

}
