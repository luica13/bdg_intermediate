package dao;

import entity.Passenger;
import entity.Trip;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PassengerDAO {
    Optional<Passenger> getById(long id);

    Set<Passenger> getAll();

    List<Passenger> get(int limit, int offset, String sort);

    Optional<Passenger> save(Passenger passenger);

    boolean saveAll(List<String> passengersAndAddresses);

    Optional<Passenger> update(Passenger passenger);

    void delete(long passengerId);

    Set<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);

    void readPassengersTripsInfoAndRegisterAll(List<String> passengersTrips);
}
