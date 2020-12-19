package com.bdg.demo.airportMgmtJPA.service;


import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.entity.Trip;

import java.util.Set;

public interface PassengerService extends GenericService<Passenger> {
    Set<Trip> getTripsOfPassenger(Passenger passenger);

    boolean registerTrip(Trip trip, Passenger passenger);

    boolean cancelTrip(Trip trip, Passenger passenger);

    void loadPassengersTripsInfoFromFile(String path);


}
