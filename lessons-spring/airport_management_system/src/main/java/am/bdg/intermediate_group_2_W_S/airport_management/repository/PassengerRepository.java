package am.bdg.intermediate_group_2_W_S.airport_management.repository;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long> {
}
