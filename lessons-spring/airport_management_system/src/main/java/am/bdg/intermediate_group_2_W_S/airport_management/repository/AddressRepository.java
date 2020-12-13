package am.bdg.intermediate_group_2_W_S.airport_management.repository;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    Address getAddressByCountryAndCity(String country, String city);
}
