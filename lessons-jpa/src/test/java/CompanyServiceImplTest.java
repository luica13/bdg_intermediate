
import dao.impl.CompanyDAOImpl;
import entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.CompanyService;
import service.impl.CompanyServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class CompanyServiceImplTest {

    private static CompanyService service;

    @BeforeAll
    static void setUp() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
        final EntityManager em = emf.createEntityManager();
        service = new CompanyServiceImpl(new CompanyDAOImpl(em));
    }

    @Test
    void getCompany() {
        Optional<Company> optionalCompany = service.getCompanyByPages(5);
        if (optionalCompany.isPresent()) assertEquals(5, optionalCompany.get().getId());
        else Assertions.fail();
    }

    @Test
    void findAll() {
        Set<Company> companies = service.findAll();
        assertFalse(companies.isEmpty());
    }

    @Test
    void testGetCompanyBySortingAndPaging() {
        List<Company> companies = service.getCompanyByPages(20, 5, "name");
        assertEquals(20, companies.size());
        assertTrue(companies.get(0).getName().startsWith("A"));
    }

    @Test
    void create() {
        Optional<Company> company = service.create(new Company("Luftganza", LocalDate.of(1983, Month.AUGUST, 7)));
        if (company.isPresent()) {
            company = service.getCompanyByPages(company.get().getId());
            if (company.isPresent()) assertEquals("Luftganza", company.get().getName());
            else Assertions.fail();
        } else Assertions.fail();
    }

    @Test
    void edit() {
        final String newName = "AirLane";
        final int id = 675;
        Optional<Company> company = service.getCompanyByPages(id);
        company.ifPresent(c -> {
            c.setName(newName);
            service.edit(c);
        });
        company = service.getCompanyByPages(id);
        if (company.isPresent()) assertEquals(newName, company.get().getName());
        else Assertions.fail();
    }

    @Test
    void remove() {
        final int id = 210;
        Optional<Company> company = service.getCompanyByPages(id);
        assertNotNull(company.orElse(null));
        service.remove(id);
        assertNull(service.getCompanyByPages(id).orElse(null));
    }
}
