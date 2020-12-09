package com.airport.repository;

import com.airport.entity.Trip;

import java.util.List;

public interface TripRepository extends Repository<Trip,Long> {
    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
