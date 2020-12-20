package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.CompanyRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.CompanyDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    @Transactional
    public CompanyDto get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            return CompanyDto.builder()
                    .id(company.getId())
                    .trips(company.getTrips().stream().map(trip -> TripDto.builder()
                            .id(trip.getId())
                            .fromCity(trip.getFromCity())
                            .toCity(trip.getToCity())
                            .timeIn(trip.getTimeIn())
                            .timeOut(trip.getTimeOut())
                            .build()).collect(Collectors.toSet()))
                    .name(company.getName())
                    .foundingDate(company.getFoundingDate())
                    .build();
        } else throw new EntityNotFoundException(String.format("company by id: %s not found.", id));
    }

    @Override
    public Set<CompanyDto> getAll() {
        Set<CompanyDto> companies = new HashSet<>();
        for (Company company : companyRepository.findAll())
            companies.add(CompanyDto.builder()
                    .id(company.getId())
                    .name(company.getName())
                    .foundingDate(company.getFoundingDate())
                    .build());
        return companies;
    }

    @Override
    public List<CompanyDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 0) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit);
        if (sortKeys != null && sortKeys.length != 0) pageRequest.getSortOr(Sort.by(sortKeys));
        return companyRepository.findAll(pageRequest).map(company -> CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .foundingDate(company.getFoundingDate())
                .build()).toList();
    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        if (companyDto == null) throw new IllegalArgumentException("company cannot be null");
        Company saved = companyRepository.save(new Company(companyDto.getName(), companyDto.getFoundingDate()));
        return CompanyDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .foundingDate(saved.getFoundingDate())
                .build();
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
    public CompanyDto edit(CompanyDto companyDto) {
        if (companyDto == null) throw new IllegalArgumentException("company cannot be null");
        Company editing = new Company(companyDto.getName(), companyDto.getFoundingDate());
        Company finalEditing = editing;
        editing.setTrips(companyDto.getTrips().stream()
                .map(tripDto -> new Trip(finalEditing, tripDto.getTimeIn(), tripDto.getTimeOut(), tripDto.getFromCity(), tripDto.getToCity()))
                .collect(Collectors.toSet()));
        editing.setId(companyDto.getId());
        editing = companyRepository.save(editing);
        return CompanyDto.builder()
                .id(editing.getId())
                .name(editing.getName())
                .foundingDate(editing.getFoundingDate())
                .build();
    }

    @Override
    public void remove(CompanyDto companyDto) {
        if (companyDto == null) throw new IllegalArgumentException("company cannot be null");
        Company company = new Company(companyDto.getName(), companyDto.getFoundingDate());
        company.setId(companyDto.getId());
        companyRepository.delete(company);
    }

    @Override
    public void removeById(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        companyRepository.deleteById(id);
    }
}
