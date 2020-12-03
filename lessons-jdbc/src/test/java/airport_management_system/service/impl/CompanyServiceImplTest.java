package airport_management_system.service.impl;

import airport_management_system.dao.impl.CompanyDAOImpl;
import airport_management_system.model.Company;
import airport_management_system.service.CompanyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceImplTest {

    private static CompanyService service;

    @BeforeAll
    static void setUp() {
        service = new CompanyServiceImpl(new CompanyDAOImpl());
    }

    @Test
    void getCompanyById() {
        Optional<Company> company = service.getCompany(456);
        if (company.isPresent()) assertEquals(456, company.get().getId());
        else Assertions.fail();
    }

    @Test
    void findAll() {
        Set<Company> companies = service.findAll();
        assertFalse(companies.isEmpty());
    }

    @Test
    void testGetCompanyBySortingAndPaging() {
        List<Company> companies = service.getCompany(20, 34, "founding_date");
        assertEquals(20, companies.size());
        assertEquals(35, companies.get(0).getId());
    }

    @Test
    void create() {
        Optional<Company> company = service.create(new Company("Luftganza", LocalDate.of(1983, Month.AUGUST, 7)));
        if (company.isPresent()) {
            company = service.getCompany(company.get().getId());
            if (company.isPresent()) assertEquals("Luftganza", company.get().getName());
            else Assertions.fail();
        } else Assertions.fail();
    }

    @Test
    void edit() {
        final String newName = "AirLane";
        final int id = 675;
        Optional<Company> company = service.getCompany(id);
        company.ifPresent(c -> {
            c.setName(newName);
            service.edit(c);
        });
        company = service.getCompany(id);
        if (company.isPresent()) assertEquals(newName, company.get().getName());
        else Assertions.fail();
    }

    @Test
    void remove() {
        final int id = 210;
        Optional<Company> company = service.getCompany(id);
        assertNotNull(company.orElse(null));
        service.remove(id);
        assertNull(service.getCompany(id).orElse(null));
    }
}
