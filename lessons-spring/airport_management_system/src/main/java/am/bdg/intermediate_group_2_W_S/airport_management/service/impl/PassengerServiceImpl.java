package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.AddressRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.PassengerRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.TripRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.CompanyDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final TripRepository tripRepository;
    private final AddressRepository addressRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository,
                                TripRepository tripRepository,
                                AddressRepository addressRepository) {
        this.passengerRepository = passengerRepository;
        this.tripRepository = tripRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public PassengerDto get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            return PassengerDto.builder()
                    .id(passenger.getId())
                    .name(passenger.getName())
                    .phone(passenger.getPhone())
                    .build();
        } else throw new EntityNotFoundException(String.format("passenger by id: %s not found.", id));
    }

    @Override
    public Set<PassengerDto> getAll() {
        Set<PassengerDto> passengers = new HashSet<>();
        for (Passenger passenger : passengerRepository.findAll())
            passengers.add(PassengerDto.builder()
                    .id(passenger.getId())
                    .name(passenger.getName())
                    .phone(passenger.getPhone())
                    .build());
        return passengers;
    }

    @Override
    public List<PassengerDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit);
        if (sortKeys != null && sortKeys.length != 0) pageRequest.getSortOr( Sort.by(sortKeys));
        return passengerRepository.findAll(pageRequest).map(passenger -> PassengerDto.builder()
                .id(passenger.getId())
                .name(passenger.getName())
                .phone(passenger.getPhone())
                .build()).toList();
    }

    @Override
    public PassengerDto create(PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        AddressDto addressDto = passengerDto.getAddress();
        Address address = new Address(addressDto.getCountry(), addressDto.getCity());
        address.setId(addressDto.getId());
        Passenger saved = passengerRepository.save(new Passenger(passengerDto.getName(), passengerDto.getPhone(), address));
        return PassengerDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .phone(saved.getPhone())
                .build();
    }

    @Override
    public PassengerDto edit(PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        AddressDto addressDto = passengerDto.getAddress();
        Address address = new Address(addressDto.getCountry(), addressDto.getCity());
        address.setId(addressDto.getId());
        Passenger editing = new Passenger(passengerDto.getName(), passengerDto.getPhone(), address);
        editing.setId(passengerDto.getId());
        editing = passengerRepository.save(editing);
        return PassengerDto.builder()
                .id(editing.getId())
                .name(editing.getName())
                .phone(editing.getPhone())
                .build();
    }

    @Override
    public void remove(PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        Address address = new Address(passengerDto.getAddress().getCountry(), passengerDto.getAddress().getCity());
        address.setId(passengerDto.getAddress().getId());
        Passenger deleting = new Passenger(passengerDto.getName(), passengerDto.getPhone(), address);
        deleting.setId(passengerDto.getId());
        passengerRepository.delete(deleting);
    }

    @Override
    public void removeById(Long passengerId) {
        if (passengerId < 1) throw new IllegalArgumentException("id cannot be less than 1");
        passengerRepository.deleteById(passengerId);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<TripDto> getTripsOfPassenger(PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerDto.getId());
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            Set<TripDto> tripDtos = new HashSet<>();
            for (Trip trip : passenger.getTrips()) {
                tripDtos.add(TripDto.builder()
                        .id(trip.getId())
                        .company(CompanyDto.builder()
                                .id(trip.getCompany().getId())
                                .name(trip.getCompany().getName())
                                .foundingDate(trip.getCompany().getFoundingDate()).build())
                        .fromCity(trip.getFromCity())
                        .toCity(trip.getToCity())
                        .timeIn(trip.getTimeIn())
                        .timeOut(trip.getTimeOut()).build());
            }
            return tripDtos;
        } else throw new EntityNotFoundException(String.format("passenger by id: %s not found.", passengerDto.getId()));
    }


    @Override
    @Transactional
    public boolean registerTrip(TripDto tripDto, PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        Trip trip  = tripRepository.findById(tripDto.getId()).orElse(null);
        Passenger passenger = passengerRepository.findById(passengerDto.getId()).orElse(null);
        if (trip != null && passenger != null) {
            if (trip.getPassengers() == null) trip.setPassengers(new HashSet<>());
            if (passenger.getTrips() == null) passenger.setTrips(new HashSet<>());
            trip.getPassengers().add(passenger);
            passenger.getTrips().add(trip);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean cancelTrip(TripDto tripDto, PassengerDto passengerDto) {
        if (passengerDto == null) throw new IllegalArgumentException("passenger cannot be null");
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        Trip trip = tripRepository.findById(tripDto.getId()).orElse(null);
        Passenger passenger = passengerRepository.findById(passengerDto.getId()).orElse(null);
        if (trip != null && passenger != null) {
            if (trip.getPassengers() == null || !trip.getPassengers().contains(passenger)) return false;
            if (passenger.getTrips() == null || !passenger.getTrips().contains(trip)) return false;
            trip.getPassengers().remove(passenger);
            passenger.getTrips().remove(trip);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void loadPassengersTripsInfoFromFile(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("illegal path");
        List<String> lines = null;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            lines = stream.skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        if (lines == null || lines.isEmpty()) return;
        for (String line : lines) {
            String[] data = line.split(",");
            Passenger passenger = passengerRepository.findById(Long.parseLong(data[0].trim())).orElse(null);
            Trip trip = tripRepository.findById(Long.parseLong(data[1].trim())).orElse(null);
            if (passenger != null && trip != null) {
                if (passenger.getTrips() == null) passenger.setTrips(new HashSet<>());
                if (trip.getPassengers() == null) trip.setPassengers(new HashSet<>());
                passenger.getTrips().add(trip);
                trip.getPassengers().add(passenger);
                System.out.println("Passenger trip successfully registered");
            } else
                System.err.println("Failed to register passenger trip, please check passenger and trip info end try again.");
        }
    }

    @Override
    @Transactional
    public void loadEntitiesInfoFromFileAndCreateAll(String path) {
        if (path == null || path.isEmpty()) throw new IllegalArgumentException("illegal path");
        List<String> lineData = null;
        try (Stream<String> fileContent = Files.lines(Paths.get(path))) {
            lineData = fileContent.skip(1).map(String::trim).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: message: " + e.getMessage());
        }
        if (lineData == null || lineData.isEmpty()) return;
        for (String line : lineData) {
            String[] data = line.split(",");
            Address address = addressRepository.getAddressByCountryAndCity(data[2].trim(), data[3].trim());
            if (address == null) address = new Address(data[2].trim(), data[3].trim());
            Passenger passenger = new Passenger(data[0].trim(), data[1].trim(), address);
            if (address.getPassengers() == null) address.setPassengers(new HashSet<>());
            address.getPassengers().add(passenger);
            addressRepository.save(address);
        }
    }
}
