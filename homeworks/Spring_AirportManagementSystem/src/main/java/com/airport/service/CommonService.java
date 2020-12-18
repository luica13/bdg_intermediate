package com.airport.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.Set;


public interface CommonService<T>{
    T getById(long id);

    Set<T> get(int page, int perPage, String... sort);

    Set<T> getAll();

    Optional<T> save( T entity);

    Optional<T> update(T entity);

    void delete(long id);


}
