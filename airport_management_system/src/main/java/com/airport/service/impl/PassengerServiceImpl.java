package com.airport.service.impl;

import com.airport.entity.Passenger;
import com.airport.entity.Trip;
import com.airport.service.PassengerService;

import java.util.List;
import java.util.Set;

public class PassengerServiceImpl implements PassengerService {
    @Override
    public Passenger findById(long id) {
        return null;
    }

    @Override
    public List<Passenger> getPassengersOfTrip(long tripNumber) {
        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {

    }

    @Override
    public void cancelTrip(long passengerId, long tripNumber) {

    }

    @Override
    public Set<Passenger> findAll() {
        return null;
    }

    @Override
    public Passenger save(Passenger entity) {
        return null;
    }

    @Override
    public Passenger update(Passenger entity) {
        return null;
    }

    @Override
    public void delete(Passenger entity) {

    }

    @Override
    public Set<Passenger> get(int page, int perPage, String sort) {
        return null;
    }
}
