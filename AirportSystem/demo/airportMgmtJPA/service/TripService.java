package com.bdg.demo.airportMgmtJPA.service;


import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.entity.Trip;

import java.util.List;
import java.util.Set;

public interface TripService extends GenericService<Trip> {

    List<Trip> getTripsFromCity(String fromCity);

    List<Trip> getTripsToCity(String toCity);

    Set<Passenger> getTripPassengers(Trip trip);
}
