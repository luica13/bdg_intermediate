package service;

import entity.Company;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyService {
    Optional<Company> getCompanyByPages(long id);

    Set<Company> findAll();

    List<Company> getCompanyByPages(int limit, int offset, String sort);

    Optional<Company> create(Company company);

    void loadCompaniesInfoFromFileAndCreateAll(String path);

    Optional<Company> edit(Company company);

    void remove(long companyId);
}
