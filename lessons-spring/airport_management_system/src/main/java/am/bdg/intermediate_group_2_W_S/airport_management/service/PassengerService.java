package am.bdg.intermediate_group_2_W_S.airport_management.service;


import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;

import java.util.Set;

public interface PassengerService extends BaseService<PassengerDto> {

    Set<TripDto> getTripsOfPassenger(PassengerDto passenger);

    boolean registerTrip(TripDto trip, PassengerDto passenger);

    boolean cancelTrip(TripDto trip, PassengerDto passenger);

    void loadPassengersTripsInfoFromFile(String path);

}
