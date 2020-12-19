package com.bdg.demo.airportMgmtJPA.service.impl;


import com.bdg.demo.airportMgmtJPA.entity.Address;
import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.repository.AddressRepository;
import com.bdg.demo.airportMgmtJPA.service.AddressService;
import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;
import com.bdg.demo.airportMgmtJPA.service.model.TripDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public  class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    @Override
    public Set<Passenger> getAddressPassengers(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return new HashSet<>(addressRepository.findById(address.getId())
                .map(Address::getPassengers).orElseGet(Collections::emptySet));
    }
//
//    @Override
//    public TripDto get(Long id) {
//        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
//        return addressRepository.findById(id).orElse(null);
//    }

    @Override
    public TripDto get(Long id) {
        return null;
    }

    @Override
    public Set<Address> getAll() {
        Set<Address> addresses = new HashSet<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public List<Address> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return addressRepository.findAll(pageRequest).toList();
    }

    @Override
    public CompanyDto create(CompanyDto entity) {
        return null;
    }

    public Optional<Address> create(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return Optional.of(addressRepository.save(address));
    }

    @Override
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Address> edit(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return Optional.of(addressRepository.save(address));
    }

    @Override
    public void remove(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        addressRepository.delete(address);
    }

    @Override
    public void removeById(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        addressRepository.deleteById(id);
    }
}