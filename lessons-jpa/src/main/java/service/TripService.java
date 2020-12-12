package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TripService {
    Optional<Trip> getTrip(long id);

    Set<Trip> findAll();

    List<Trip> getTrips(int limit, int offset, String sort);

    Optional<Trip> create(Trip trip);

    Optional<Trip> edit(Trip trip);

    void remove(long tripId);

    Set<Trip> getPassengerTrips(long passengerId);

    List<Trip> getTripsFromCity(String fromCity);

    List<Trip> getTripsToCity(String toCity);

    void loadTripsInfoFromFileAndCreateAll(String path);

    Set<Passenger> getTripPassengers(long tripId);
}
