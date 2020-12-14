package com.airport.repository;

import com.airport.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
//    List<Trip> getTripsFrom(String city);
//
//    List<Trip> getTripsTo(String city);
}
