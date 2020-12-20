package com.bdg.demo.airportMgmtJPA.service;

import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;
import com.bdg.demo.airportMgmtJPA.service.model.TripDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenericService<T> {
    TripDto get(Long id);

    Set<T> getAll();

    List<T> getCertainCrowd(int limit, int offset, String... sortKeys);

    //not so generic , yes?
    CompanyDto create(CompanyDto entity);

    void loadEntitiesInfoFromFileAndCreateAll(String path);

    Optional<T> edit(T entity);
    //edit? is it the same as update?

    void remove(T entity);

    void removeById(Long id);
}
