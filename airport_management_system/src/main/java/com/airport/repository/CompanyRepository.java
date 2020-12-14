package com.airport.repository;

import com.airport.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select c from Company c where c.name = ?1 ")
    List<Company> getByNameStartedWith(String name);
}
