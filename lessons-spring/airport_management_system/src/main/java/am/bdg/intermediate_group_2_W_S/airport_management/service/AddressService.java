package am.bdg.intermediate_group_2_W_S.airport_management.service;

import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;

import java.util.Set;

public interface AddressService extends BaseService<AddressDto> {
    Set<PassengerDto> getAddressPassengers(AddressDto address);
}
