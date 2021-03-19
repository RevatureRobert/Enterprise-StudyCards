package dev.enterprise.repo;

import java.util.List;

public interface CrudRepository <T,I>{
    int save(T t);
    int update(T t);
    T findById(I i);
    List<T> findAll();

}
