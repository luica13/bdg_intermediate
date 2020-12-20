package com.bdg.demo.airportMgmtJPA.service.impl;

import com.bdg.demo.airportMgmtJPA.entity.Address;
import com.bdg.demo.airportMgmtJPA.entity.Company;
import com.bdg.demo.airportMgmtJPA.repository.CompanyRepository;
import com.bdg.demo.airportMgmtJPA.service.CompanyService;
import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;
import com.bdg.demo.airportMgmtJPA.service.model.TripDto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public TripDto get(Long id) {
        //same here
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            return new CompanyDto(company.getId(), company.getName(),
                    company.getFoundingDate(), company.getTrips());
        }
        throw new EntityNotFoundException(String.format("Company with id:%s not found", id));
        //where are you catching these exceptions?
    }

    @Override
    public Set<CompanyDto> getAll() {
        return null;
    }

    @Override
    public List<CompanyDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
        return null;
    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        if (companyDto == null) throw new IllegalArgumentException("company cannot be null");
        Company company = new Company(companyDto.getName(), companyDto.getFoundingDate());
        //why keep new object?
        Company saveComp = companyRepository.save(company);
        //do we need to load the trips as well?
        return new CompanyDto(saveComp.getId(), saveComp.getName(), saveComp.getFoundingDate(), saveComp.getTrips());
    }

    @Override
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {

    }

    @Override
    public Optional<CompanyDto> edit(CompanyDto entity) {
        return Optional.empty();
    }

    @Override
    public void remove(CompanyDto entity) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public Optional<Address> create(Company entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Company> edit(Company company) {
        return Optional.empty();
    }

    @Override
    public void remove(Company company) {

    }
//
//    @Override
//    public Set<CompanyDto> getAll() {
//        Set<Company> companies = new HashSet<>();
//        companyRepository.findAll().forEach(companies::add);
//        return companies;
//    }
//
//    @Override
//    public List<CompanyDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
//        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
//        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
//        return companyRepository.findAll(pageRequest).toList();
//    }
//
//    @Override
//    public Optional<Address> create(Company entity) {
//        return null;
//    }
//
//    @Override
//    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
//        if (path == null || path.isEmpty()) throw new IllegalArgumentException("illegal path");
//        List<String> lineData = null;
//        try (Stream<String> fileContent = Files.lines(Paths.get(path))) {
//            lineData = fileContent.skip(1).map(String::trim).collect(Collectors.toList());
//        } catch (IOException e) {
//            System.err.println("An error occurred while reading the file: message: " + e.getMessage());
//            return;
//        }
//        if (lineData.isEmpty()) return;
//        List<Company> companies = new ArrayList<>(lineData.size());
//        for (String line : lineData) {
//            String[] data = line.split(",");
//            companies.add(new Company(data[0].trim(), LocalDate.parse(data[1].trim(),
//                    DateTimeFormatter.ofPattern("M/d/yyyy", Locale.US))));
//        }
//        if (companies.isEmpty()) return;
//        companyRepository.saveAll(companies);
//    }
//
//    @Override
//    public Optional<Company> edit(Company company) {
//        if (company == null) throw new IllegalArgumentException("company cannot be null");
//        return Optional.of(companyRepository.save(company));
//    }
//
//    @Override
//    public void remove(Company company) {
//        if (company == null) throw new IllegalArgumentException("company cannot be null");
//        companyRepository.delete(company);
//    }
//
//    @Override
//    public void removeById(Long id) {
//        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
//        companyRepository.deleteById(id);
//    }
}