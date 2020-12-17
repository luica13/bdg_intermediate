package am.bdg.intermediate_group_2_W_S.airport_management.repository;

import am.bdg.intermediate_group_2_W_S.airport_management.model.Passenger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long> {
}
