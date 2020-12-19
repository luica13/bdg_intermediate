package com.bdg.demo.airportMgmtJPA.controller;


import com.bdg.demo.airportMgmtJPA.entity.Company;
import com.bdg.demo.airportMgmtJPA.repository.CompanyRepository;
import com.bdg.demo.airportMgmtJPA.service.CompanyService;
import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    private final CompanyService companyService;

    CompanyRepository companyRepository = null;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        CompanyDto companyDto = null;
        try {
            companyDto =  companyService.get(id);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }


    @DeleteMapping("/company/{id}")
    public void deleteById(@PathVariable long id){
       CompanyDto companyDto = null;
        companyRepository.deleteById(id);
    }

    @DeleteMapping("/company/")
    public void deleteAll(){
        companyRepository.deleteAll();
    }


    @PutMapping("/company/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Company company, @PathVariable long id) {

        Optional<Company> studentOptional = companyRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        company.setId(id);

        companyRepository.save(company);

        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public CompanyDto create(@RequestBody @Valid Company company) {
        CompanyDto companyDto = new CompanyDto(company.getId(), company.getName(), company.getFoundingDate(), company.getTrips());
        companyDto = companyService.create(companyDto);
        return companyDto;
    }
}
