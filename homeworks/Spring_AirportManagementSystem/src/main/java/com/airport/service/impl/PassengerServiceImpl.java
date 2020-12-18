package com.airport.service.impl;

import com.airport.entity.Address;
import com.airport.entity.Passenger;
import com.airport.repository.PassengerRepository;
import com.airport.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository repository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Passenger getById(long id) {
        Passenger value = repository.getOne(id);
        return value;
    }

    @Override
    public Set<Passenger> get(int page, int perPage, String... sort) {
        if (page < 1 || perPage < 1 || sort == null) {
            throw new IllegalArgumentException("present illegal argument");
        }
        PageRequest pageRequest = PageRequest.of(page, perPage, Sort.by(sort));
        Set<Passenger> set = new HashSet<>(repository.findAll(pageRequest).toList());
        return set;
    }

    @Override
    public Set<Passenger> getAll() {
        List<Passenger> values = repository.findAll();
        Set<Passenger> set = new HashSet<>(values);
        return set;
    }

    @Override
    public Optional<Passenger> save(Passenger entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<Passenger> update(Passenger entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }


    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return repository.getPassengersOfTrip(tripNumber);
    }
}
