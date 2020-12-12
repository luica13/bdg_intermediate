package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CompanyService {
    Optional<Company> getCompany(long id);

    Set<Company> findAll();

    List<Company> getCompany(int limit, int offset, String sort);

    Optional<Company> create(Company company);

    void loadCompaniesInfoFromFileAndCreateAll(String path);

    Optional<Company> edit(Company company);

    void remove(long companyId);
}
