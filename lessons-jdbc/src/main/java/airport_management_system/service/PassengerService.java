package airport_management_system.service;

import airport_management_system.model.Passenger;
import airport_management_system.model.Trip;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PassengerService {
    Optional<Passenger> get(long id);

    Set<Passenger> findAll();

    List<Passenger> getPassengers(int page, int perPage, String sort);

    Optional<Passenger> create(Passenger passenger);

    void loadPassengersInfoFromFileAndCreateAll(String path);

    Optional<Passenger> edit(Passenger passenger);

    void remove(long passengerId);

    Set<Passenger> getPassengersOfTrip(long tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(long passengerId, long tripNumber);

}
