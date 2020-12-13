package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.AddressRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.PassengerRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.TripRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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
    public Optional<Passenger> get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        return passengerRepository.findById(id);
    }

    @Override
    public Set<Passenger> getAll() {
        return Stream.of(passengerRepository.findAll().iterator().next())
                .collect(Collectors.toSet());
    }

    @Override
    public List<Passenger> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return passengerRepository.findAll(pageRequest).toList();
    }

    @Override
    public Optional<Passenger> create(Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        return Optional.of(passengerRepository.save(passenger));
    }

    @Override
    public Optional<Passenger> edit(Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        return Optional.of(passengerRepository.save(passenger));
    }

    @Override
    public void remove(Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        passengerRepository.delete(passenger);
    }

    @Override
    public void removeById(Long passengerId) {
        if (passengerId < 1) throw new IllegalArgumentException("id cannot be less than 1");
        passengerRepository.deleteById(passengerId);
    }

    @Override
    public Set<Trip> getTripsOfPassenger(Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        passenger = passengerRepository.findById(passenger.getId()).orElse(null);
        return passenger == null ? Collections.emptySet() : passenger.getTrips();
    }


    @Override
    @Transactional
    public boolean registerTrip(Trip trip, Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        if (trip == null) throw new IllegalArgumentException("trip cannot be null");
        trip = tripRepository.findById(trip.getId()).orElse(null);
        passenger = passengerRepository.findById(passenger.getId()).orElse(null);
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
    public boolean cancelTrip(Trip trip, Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        if (trip == null) throw new IllegalArgumentException("trip cannot be null");
        trip = tripRepository.findById(trip.getId()).orElse(null);
        passenger = passengerRepository.findById(passenger.getId()).orElse(null);
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
