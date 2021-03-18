package dev.enterprise.repo;

import java.util.List;

public interface CrudRepository <T,I>{
    void save(T t);
    void update(T t);
    T findById(I i);
    List<T> findAll();

}
