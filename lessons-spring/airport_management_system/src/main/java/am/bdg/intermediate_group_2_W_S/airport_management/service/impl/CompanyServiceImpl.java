package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.CompanyRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        return companyRepository.findById(id);
    }

    @Override
    public Set<Company> getAll() {
        Set<Company> companies = new HashSet<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public List<Company> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return companyRepository.findAll(pageRequest).toList();
    }

    @Override
    public Optional<Company> create(Company company) {
        if (company == null) throw new IllegalArgumentException("company cannot be null");
        return Optional.of(companyRepository.save(company));
    }

    @Override
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("illegal path");
        List<String> lineData = null;
        try (Stream<String> fileContent = Files.lines(Paths.get(path))) {
            lineData = fileContent.skip(1).map(String::trim).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: message: " + e.getMessage());
            return;
        }
        if (lineData.isEmpty()) return;
        List<Company> companies = new ArrayList<>(lineData.size());
        for (String line : lineData) {
            String[] data = line.split(",");
            companies.add(new Company(data[0].trim(), LocalDate.parse(data[1].trim(),
                    DateTimeFormatter.ofPattern("M/d/yyyy", Locale.US))));
        }
        if (companies.isEmpty()) return;
        companyRepository.saveAll(companies);
    }

    @Override
    public Optional<Company> edit(Company company) {
        if (company == null) throw new IllegalArgumentException("company cannot be null");
        return Optional.of(companyRepository.save(company));
    }

    @Override
    public void remove(Company company) {
        if (company == null) throw new IllegalArgumentException("company cannot be null");
        companyRepository.delete(company);
    }

    @Override
    public void removeById(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        companyRepository.deleteById(id);
    }
}
