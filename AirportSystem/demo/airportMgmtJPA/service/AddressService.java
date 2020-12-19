package com.bdg.demo.airportMgmtJPA.service;

import com.bdg.demo.airportMgmtJPA.entity.Address;
import com.bdg.demo.airportMgmtJPA.entity.Passenger;

import javax.transaction.Transactional;
import java.util.Set;

public interface AddressService extends GenericService<Address> {
    Set<Passenger> getAddressPassengers(Address address);
}