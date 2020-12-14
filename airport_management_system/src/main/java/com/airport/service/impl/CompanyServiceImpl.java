package com.airport.service.impl;

import com.airport.entity.Company;
import com.airport.repository.CompanyRepository;
import com.airport.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public Company findById(long id) {
        Company company = companyRepository.getOne(id);
        company.setId(4L);
        return company;
    }

    @Override
    public Set<Company> findAll() {
        List<Company> all = companyRepository.findAll();
        return new HashSet<>(all);
    }

    @Override
    @Transactional
    public Company save(Company entity) {
        return companyRepository.save(entity);
    }

    @Override
    @Transactional
    public Company update(Company entity) {
        return companyRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Company entity) {
        companyRepository.delete(entity);
    }

    @Override
    public Set<Company> get(int page, int perPage, String sort) {
        PageRequest request = PageRequest.of(page, perPage, Sort.by(sort));
        Page<Company> all = companyRepository.findAll(request);
        return all.toSet();
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
