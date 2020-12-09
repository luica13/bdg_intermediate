package com.airport.repository;

import com.airport.entity.Passenger;

import java.util.List;

public interface PassengerRepository extends Repository<Passenger,Long> {
    List<Passenger> getPassengersOfTrip(long tripNumber);
}
