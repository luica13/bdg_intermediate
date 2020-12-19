package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;

import java.util.List;
import java.util.Set;

public interface TripService extends BaseService<TripDto> {

    List<TripDto> getTripsFromCity(String fromCity);

    List<TripDto> getTripsToCity(String toCity);

    Set<PassengerDto> getTripPassengers(TripDto trip);
}
