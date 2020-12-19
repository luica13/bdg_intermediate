package com.bdg.demo.airportMgmtJPA.service.impl;


import com.bdg.demo.airportMgmtJPA.entity.Address;
import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.entity.Trip;
import com.bdg.demo.airportMgmtJPA.repository.AddressRepository;
import com.bdg.demo.airportMgmtJPA.repository.PassengerRepository;
import com.bdg.demo.airportMgmtJPA.repository.TripRepository;
import com.bdg.demo.airportMgmtJPA.service.PassengerService;
import com.bdg.demo.airportMgmtJPA.service.model.PassengerDto;
import com.bdg.demo.airportMgmtJPA.service.model.TripDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final TripRepository tripRepository;
    private final AddressRepository addressRepository;

    protected PassengerServiceImpl(PassengerRepository passengerRepository,
                                   TripRepository tripRepository,
                                   AddressRepository addressRepository) {
        this.passengerRepository = passengerRepository;
        this.tripRepository = tripRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public TripDto get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less then 1");
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if(optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            PassengerDto passengerDto = new PassengerDto(passenger.getId(), passenger.getName(),
                    passenger.getPhone(), passenger.getCountry(), passenger.getCity());
            return passengerDto;
        }
        throw new EntityNotFoundException(String.format("Company with id:%s not found", id));
    }

    @Override
    public Set<Passenger> getAll() {
        Set<Passenger> passengers = new HashSet<>();
        passengerRepository.findAll().forEach(passengers::add);
        return passengers;
    }

    @Override
    public List<Passenger> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 1 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return passengerRepository.findAll(pageRequest).toList();
    }

    @Override
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
    @Transactional
    public Set<Trip> getTripsOfPassenger(Passenger passenger) {
        if (passenger == null) throw new IllegalArgumentException("passenger cannot be null");
        return new HashSet<>(passengerRepository.findById(passenger.getId())
                .map(Passenger::getTrips).orElseGet(Collections::emptySet));
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
                System.out.println("PassengerDto trip successfully registered");
            } else
                System.err.println("Failed to register passenger trip, please check passenger and trip info end try again.");
        }
    }
}
