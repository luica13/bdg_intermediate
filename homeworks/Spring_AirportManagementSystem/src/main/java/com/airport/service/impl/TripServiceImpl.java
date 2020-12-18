package com.airport.service.impl;

import com.airport.entity.Company;
import com.airport.entity.Trip;
import com.airport.repository.CompanyRepository;
import com.airport.repository.TripRepository;
import com.airport.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TripServiceImpl implements TripService {
    private TripRepository repository;

    @Autowired
    public TripServiceImpl(TripRepository repository) {
        this.repository = repository;
    }

    @Override
    public Trip getById(long id) {
        Trip value = repository.getOne(id);
        return value;
    }

    @Override
    public Set<Trip> get(int page, int perPage, String... sort) {
        if (page < 1 || perPage < 1 || sort == null) {
            throw new IllegalArgumentException("present illegal argument");
        }
        PageRequest pageRequest = PageRequest.of(page, perPage, Sort.by(sort));
        Set<Trip> set = new HashSet<>(repository.findAll(pageRequest).toList());
        return set;
    }

    @Override
    public Set<Trip> getAll() {
        List<Trip> values = repository.findAll();
        Set<Trip> set = new HashSet<>(values);
        return set;
    }

    @Override
    public Optional<Trip> save(Trip entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<Trip> update(Trip entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }


    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
