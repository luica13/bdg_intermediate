package com.bdg.demo.airportMgmtJPA.repository;

import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}