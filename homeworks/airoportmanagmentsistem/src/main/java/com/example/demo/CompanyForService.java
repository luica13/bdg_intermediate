package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyForService {
        Optional<CompanyForService> getCompany(long id);

        Set<CompanyForService> findAll();

        List<CompanyForService> getCompany(int page, int perPage, String sort);

        Optional<CompanyForService> create(CompanyForService company);

        void loadCompaniesInfoFromFileAndCreateAll(String path);

        Optional<CompanyForService> edit(CompanyForService company);

        void remove(long companyId);
}
