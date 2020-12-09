package com.airport.service;

import com.airport.entity.Passenger;
import com.airport.entity.Trip;

import java.util.List;

public interface PassengerService extends Service<Passenger> {
    Passenger findById(long id);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);
}
