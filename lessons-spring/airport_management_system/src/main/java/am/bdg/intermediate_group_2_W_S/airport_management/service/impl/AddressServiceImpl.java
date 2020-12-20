package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.AddressRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public AddressDto get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        Optional<Address> optionalAddress = repository.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            return AddressDto.builder()
                    .city(address.getCity())
                    .country(address.getCountry())
                    .id(address.getId())
                    .passengers(address.getPassengers().stream().map(passenger ->
                            PassengerDto.builder()
                                    .id(passenger.getId())
                                    .name(passenger.getName())
                                    .phone(passenger.getPhone())
                                    .build()).collect(Collectors.toSet()))
                    .build();
        } else throw new EntityNotFoundException(String.format("address by id: %s not found.", id));
    }

    @Override
    public Set<AddressDto> getAll() {
        Set<AddressDto> addresses = new HashSet<>();
        for (Address address : repository.findAll())
            addresses.add(AddressDto.builder()
                    .city(address.getCity())
                    .country(address.getCountry())
                    .id(address.getId())
                    .build());
        return addresses;
    }

    @Override
    public List<AddressDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 0) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit);
        if (sortKeys != null && sortKeys.length != 0) pageRequest.getSortOr(Sort.by(sortKeys));
        return repository.findAll(pageRequest).map(address -> AddressDto.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .id(address.getId())
                .build()).toList();
    }

    @Override
    public AddressDto create(AddressDto addressDto) {
        if (addressDto == null) throw new IllegalArgumentException("address cannot be null");
        Address saved = repository.save(new Address(addressDto.getCountry(), addressDto.getCity()));
        return AddressDto.builder()
                .city(saved.getCity())
                .country(saved.getCountry())
                .id(saved.getId())
                .build();
    }

    @Override
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AddressDto edit(AddressDto addressDto) {
        if (addressDto == null) throw new IllegalArgumentException("address cannot be null");
        Address editing = new Address(addressDto.getCountry(), addressDto.getCity());
        Address finalEditing = editing;
        editing.setPassengers(addressDto.getPassengers().stream().map(passengerDto -> {
            Passenger passenger = new Passenger(passengerDto.getName(), passengerDto.getPhone(), finalEditing);
            passenger.setId(passengerDto.getId());
            return passenger;
        }).collect(Collectors.toSet()));
        editing.setId(addressDto.getId());
        editing = repository.save(editing);
        return AddressDto.builder()
                .city(editing.getCity())
                .country(editing.getCountry())
                .id(editing.getId())
                .build();
    }

    @Override
    public void remove(AddressDto addressDto) {
        if (addressDto == null) throw new IllegalArgumentException("address cannot be null");
        Address deleting = new Address(addressDto.getCountry(), addressDto.getCity());
        deleting.setId(addressDto.getId());
        deleting.setPassengers(addressDto.getPassengers().stream().map(passengerDto -> {
            Passenger passenger = new Passenger(passengerDto.getName(), passengerDto.getPhone(), deleting);
            passenger.setId(passengerDto.getId());
            passenger.setAddress(null);
            return passenger;
        }).collect(Collectors.toSet()));
        repository.delete(deleting);
    }

    @Override
    public void removeById(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<PassengerDto> getAddressPassengers(AddressDto addressDto) {
        if (addressDto == null) throw new IllegalArgumentException("address cannot be null");
        return repository.findById(addressDto.getId()).map(Address::getPassengers).get()
                .stream().map(passenger -> {
                    Address address = passenger.getAddress();
                    return PassengerDto.builder()
                            .id(passenger.getId())
                            .address(AddressDto.builder()
                                    .id(address.getId())
                                    .country(address.getCountry())
                                    .city(address.getCity())
                                    .build())
                            .name(passenger.getName())
                            .phone(passenger.getPhone())
                            .build();
                })
                .collect(Collectors.toSet());
    }
}
