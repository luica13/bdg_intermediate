package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.model.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.model.Passenger;

import java.util.Set;

public interface AddressService extends BaseService<Address> {
    Set<Passenger> getAddressPassengers(Address address);
}
