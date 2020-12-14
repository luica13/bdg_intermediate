package com.airport.service;

import com.airport.entity.Passenger;
import com.airport.entity.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PassengerService extends GenericService<Passenger> {
    Passenger findById(long id);

    List<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);
}
