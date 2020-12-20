package com.bdg.demo.airportMgmtJPA.repository;


import com.bdg.demo.airportMgmtJPA.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//no need of annotaion
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
