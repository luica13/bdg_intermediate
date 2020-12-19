package am.bdg.intermediate_group_2_W_S.airport_management.repository;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip, Long> {
    List<Trip> getAllByFromCity(String fromCity);

    List<Trip> getAllByToCity(String toCity);
}
