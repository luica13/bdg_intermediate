package am.bdg.intermediate_group_2_W_S.airport_management.repository;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {
    List<Trip> getAllByFromCity(String fromCity);

    List<Trip> getAllByToCity(String toCity);
}
