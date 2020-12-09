package com.airport.repository;

import java.util.Set;

public interface Repository<T,ID> {
    T findById(ID id);

    Set<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(ID id);

    Set<T> get(int page, int perPage, String sort);
}
