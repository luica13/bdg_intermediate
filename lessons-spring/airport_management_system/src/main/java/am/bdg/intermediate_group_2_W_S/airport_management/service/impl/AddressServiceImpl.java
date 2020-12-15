package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.AddressRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Address> get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        return repository.findById(id);
    }

    @Override
    public Set<Address> getAll() {
        return Stream.of(repository.findAll().iterator().next())
                .collect(Collectors.toSet());
    }

    @Override
    public List<Address> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return repository.findAll(pageRequest).toList();
    }

    @Override
    public Optional<Address> create(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return Optional.of(repository.save(address));
    }

    @Override
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Address> edit(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return Optional.of(repository.save(address));
    }

    @Override
    public void remove(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        repository.delete(address);
    }

    @Override
    public void removeById(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Set<Passenger> getAddressPassengers(Address address) {
        if (address == null) throw new IllegalArgumentException("address cannot be null");
        return repository.findById(address.getId())
                .map(Address::getPassengers).orElseGet(Collections::emptySet);
    }
}
