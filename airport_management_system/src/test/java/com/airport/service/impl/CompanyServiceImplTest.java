package com.airport.service.impl;

import com.airport.entity.Company;
import com.airport.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompanyServiceImplTest {
    private static Company company;
    private final static Long TEST_ID = 1L;
    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @BeforeAll
    static void setUp() {
        company = new Company();
        company.setId(TEST_ID);
    }

    @Test
    void findById() {
        Company c = new Company();
        c.setId(TEST_ID);
        when(companyRepository.getOne(TEST_ID)).thenReturn(c);

        Company testableCompany = companyService.findById(TEST_ID);

        assertEquals(TEST_ID, testableCompany.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

}