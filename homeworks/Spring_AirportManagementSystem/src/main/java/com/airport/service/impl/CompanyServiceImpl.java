package com.airport.service.impl;

import com.airport.entity.Company;
import com.airport.entity.Passenger;
import com.airport.repository.CompanyRepository;
import com.airport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Company getById(long id) {
        Company value = repository.getOne(id);
        return value;
    }

    @Override
    public Set<Company> get(int page, int perPage, String... sort) {
        if (page < 1 || perPage < 1 || sort == null) {
            throw new IllegalArgumentException("present illegal argument");
        }
        PageRequest pageRequest = PageRequest.of(page, perPage, Sort.by(sort));
        Set<Company> set = new HashSet<>(repository.findAll(pageRequest).toList());
        return set;
    }

    @Override
    public Set<Company> getAll() {
        List<Company> values = repository.findAll();
        Set<Company> set = new HashSet<>(values);
        return set;
    }

    @Override
    public Optional<Company> save(Company entity) {
        if (entity == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<Company> update(Company entity) {
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
