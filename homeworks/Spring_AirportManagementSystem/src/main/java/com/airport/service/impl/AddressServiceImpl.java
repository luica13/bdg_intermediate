package com.airport.service.impl;

import com.airport.entity.Address;
import com.airport.repository.AddressRepository;
import com.airport.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address getById(long id) {
        Address address = repository.getOne(id);
        return address;
    }

    @Override
    public Set<Address> get(int page, int perPage, String... sort) {
        if (page < 1 || perPage < 1 || sort == null) {
            throw new IllegalArgumentException("present illegal argument");
        }
        PageRequest pageRequest = PageRequest.of(page, perPage, Sort.by(sort));
        Set<Address> addressSet = new HashSet<>(repository.findAll(pageRequest).toList());
        return addressSet;
    }

    @Override
    public Set<Address> getAll() {
        List<Address> addresses = repository.findAll();
        Set<Address> addressSet = new HashSet<>(addresses);
        return addressSet;
    }

    @Override
    public Optional<Address> save(Address entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<Address> update(Address entity) {
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
