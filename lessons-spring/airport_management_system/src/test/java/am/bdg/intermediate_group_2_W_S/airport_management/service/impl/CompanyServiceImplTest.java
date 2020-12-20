package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.CompanyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class CompanyServiceImplTest {

    @Autowired
    private CompanyService service;

    @Test
    void getCompany() {
        CompanyDto companyDto = service.get(5L);
        assertNotNull(companyDto);
        assertEquals(5, companyDto.getId());
    }

    @Test
    void findAll() {
        Set<CompanyDto> companies = service.getAll();
        assertFalse(companies.isEmpty());
    }

    @Test
    void testGetCompanyBySortingAndPaging() {
        List<CompanyDto> companies = service.getCertainCrowd(20, 1, "name");
        assertEquals(20, companies.size());
    }

    @Test
    void create() {
        CompanyDto company = service.create(CompanyDto.builder()
                .name("Hanssa")
                .foundingDate(LocalDate.of(1999, Month.AUGUST, 7))
                .build());
        assertNotNull(company);
        company = service.get(company.getId());
        assertNotNull(company);
        assertEquals("Hanssa", company.getName());
    }

    @Test
    void edit() {
        final String newName = "AirLane";
        final Long id = 124L;
        CompanyDto company = service.get(id);
        assertNotNull(company);
        company.setName(newName);
        company = service.edit(company);
        assertNotNull(company);
        company = service.get(id);
        assertNotNull(company);
        assertEquals(newName, company.getName());
    }

    @Test
    void remove() {
        final Long id = 211L;
        CompanyDto company = service.get(id);
        assertNotNull(company);
        service.remove(company);
        assertThrows(EntityNotFoundException.class, () -> service.get(id));
    }

    @Test
    void removeById() {
        final Long id = 101L;
        CompanyDto company = service.get(id);
        assertNotNull(company);
        service.removeById(id);
        assertThrows(EntityNotFoundException.class, () -> service.get(id));
    }
}
