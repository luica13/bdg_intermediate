package com.bdg.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    Optional<T> find(Long id);
    void save(T t);
    void update(T t);
    void delete(Long id);

    List<T> findAll();
}
