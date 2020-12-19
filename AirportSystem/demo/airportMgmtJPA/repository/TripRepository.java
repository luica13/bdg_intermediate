package com.bdg.demo.airportMgmtJPA.repository;


import com.bdg.demo.airportMgmtJPA.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {

    List<Trip> getAllByFromCity(String fromCity);

    List<Trip> getAllByToCity(String toCity);
}