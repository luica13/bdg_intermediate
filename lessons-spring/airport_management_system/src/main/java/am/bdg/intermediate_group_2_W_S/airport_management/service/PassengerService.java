package am.bdg.intermediate_group_2_W_S.airport_management.service;


import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;

import java.util.Set;

public interface PassengerService extends BaseService<Passenger> {

    Set<Trip> getTripsOfPassenger(Passenger passenger);

    boolean registerTrip(Trip trip, Passenger passenger);

    boolean cancelTrip(Trip trip, Passenger passenger);

    void loadPassengersTripsInfoFromFile(String path);

}
