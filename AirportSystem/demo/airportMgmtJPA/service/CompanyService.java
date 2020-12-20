package com.bdg.demo.airportMgmtJPA.service;


import com.bdg.demo.airportMgmtJPA.entity.Address;
import com.bdg.demo.airportMgmtJPA.entity.Company;
import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;

import java.util.Optional;

public interface CompanyService extends GenericService<CompanyDto> {

//Address? 
    Optional<Address> create(Company entity);

    Optional<Company> edit(Company company);

    void remove(Company company);
}
