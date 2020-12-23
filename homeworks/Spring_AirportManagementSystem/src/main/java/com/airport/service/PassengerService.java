package com.airport.service;

import com.airport.entity.Passenger;

import java.util.List;

public interface PassengerService extends CommonService<Passenger> {
    List<Passenger> getPassengersOfTrip(long tripNumber);
}
