package com.airport.service;

import com.airport.entity.Company;

public interface CompanyService extends Service<Company> {
    Company findById(long id);
}
