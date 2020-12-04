package service.impl;

import dao.CompanyDAO;
import entity.Company;
import service.CompanyService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public Optional<Company> getCompanyByPages(long id) {
        return companyDAO.getById(id);
    }

    @Override
    public Set<Company> findAll() {
        return companyDAO.getAll();
    }

    @Override
    public List<Company> getCompanyByPages(int limit, int offset, String sort) {
        return companyDAO.get(limit, offset, sort);
    }

    @Override
    public Optional<Company> create(Company company) {
        return companyDAO.save(company);
    }

    @Override
    public void loadCompaniesInfoFromFileAndCreateAll(String path) {
        List<String> lineData = null;
        try (Stream<String> fileContent = Files.lines(Paths.get(path))) {
            lineData = fileContent.skip(1).map(String::trim).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: message: " + e.getMessage());
        }
        companyDAO.saveAll(lineData != null ? lineData : Collections.emptyList());
    }

    @Override
    public Optional<Company> edit(Company company) {
        return companyDAO.update(company);
    }

    @Override
    public void remove(long companyId) {
        companyDAO.delete(companyId);
    }
}
