package service;

import entity.Passenger;
import entity.Trip;

import java.util.Optional;
import java.util.Set;

public interface PassengerService {
    Optional<Passenger> get(long id);

    Set<Passenger> findAll();

    Set<Passenger> getPassengers(int offset, int limit, String sort);

    Optional<Passenger> create(Passenger passenger);

    void loadPassengersInfoFromFileAndCreateAll(String path);

    Optional<Passenger> edit(Passenger passenger);

    void remove(long passengerId);

    Set<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);

    void loadPassengersTripsInfoFromFile(String path);

}
