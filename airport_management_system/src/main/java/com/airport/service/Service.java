package com.airport.service;

import java.util.Set;

public interface Service<T> {
    Set<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    Set<T> get(int page, int perPage, String sort);
}
