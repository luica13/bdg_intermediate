package com.airport.service;

import com.airport.entity.Trip;

import java.util.List;

public interface TripService extends Service<Trip> {
    Trip findById(long id);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);
}
