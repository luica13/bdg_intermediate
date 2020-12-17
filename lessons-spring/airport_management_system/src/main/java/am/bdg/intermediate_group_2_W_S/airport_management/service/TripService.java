package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.model.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripService extends BaseService<Trip> {

    List<Trip> getTripsFromCity(String fromCity);

    List<Trip> getTripsToCity(String toCity);

    Set<Passenger> getTripPassengers(Trip trip);
}
