package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;

import java.util.List;
import java.util.Set;

public interface TripService extends BaseService<Trip> {

    List<Trip> getTripsFromCity(String fromCity);

    List<Trip> getTripsToCity(String toCity);

    Set<Passenger> getTripPassengers(Trip trip);
}
