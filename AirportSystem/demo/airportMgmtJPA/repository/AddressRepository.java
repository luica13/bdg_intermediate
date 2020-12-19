package com.bdg.demo.airportMgmtJPA.repository;


import com.bdg.demo.airportMgmtJPA.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address getAddressByCountryAndCity(String country, String city);
}