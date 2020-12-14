import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class CompanyServiceImplTest {

    @Autowired
    private CompanyService service;

    @Test
    void getCompany() {
        Optional<Company> optionalCompany = service.get(5L);
        if (optionalCompany.isPresent()) assertEquals(5, optionalCompany.get().getId());
        else Assertions.fail();
    }

    @Test
    void findAll() {
        Set<Company> companies = service.getAll();
        assertFalse(companies.isEmpty());
    }

    @Test
    void testGetCompanyBySortingAndPaging() {
        List<Company> companies = service.getCertainCrowd(20, 1, "name");
        assertEquals(20, companies.size());
        assertTrue(companies.get(0).getName().startsWith("A"));
    }

    @Test
    void create() {
        Optional<Company> company = service.create(new Company("Hanssa", LocalDate.of(1999, Month.AUGUST, 7)));
        if (company.isPresent()) {
            company = service.get(company.get().getId());
            if (company.isPresent()) assertEquals("Hanssa", company.get().getName());
            else Assertions.fail();
        } else Assertions.fail();
    }

    @Test
    void edit() {
        final String newName = "AirLane";
        final Long id = 635L;
        Optional<Company> company = service.get(id);
        company.ifPresent(c -> {
            c.setName(newName);
            service.edit(c);
        });
        company = service.get(id);
        if (company.isPresent()) assertEquals(newName, company.get().getName());
        else Assertions.fail();
    }

    @Test
    void remove() {
        final Long id = 211L;
        Optional<Company> optionalCompany = service.get(id);
        optionalCompany.ifPresentOrElse(service::remove, Assertions::fail);
        assertNull(service.get(id).orElse(null));
    }
}
