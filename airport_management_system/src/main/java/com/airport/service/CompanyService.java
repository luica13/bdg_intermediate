package com.airport.service;

import com.airport.entity.Company;
import org.springframework.stereotype.Service;

public interface CompanyService extends GenericService<Company> {
    Company findById(long id);
}
