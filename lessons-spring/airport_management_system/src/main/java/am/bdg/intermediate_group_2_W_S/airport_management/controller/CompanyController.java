package am.bdg.intermediate_group_2_W_S.airport_management.controller;

import am.bdg.intermediate_group_2_W_S.airport_management.controller.model.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.model.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        CompanyDto companyDto = null;
        try {
            companyDto = companyService.get(id);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @PostMapping
    public CompanyDto create(@RequestBody @Valid Company company) {
        CompanyDto companyDto = new CompanyDto(company.getId(), company.getName(), company.getFoundingDate(), company.getTrips());
        companyDto = companyService.create(companyDto);
        return companyDto;
    }
}
