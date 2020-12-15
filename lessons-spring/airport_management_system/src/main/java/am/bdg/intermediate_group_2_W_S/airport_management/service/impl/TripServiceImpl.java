package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.CompanyRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.TripRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final CompanyRepository companyRepository;

    public TripServiceImpl(TripRepository tripRepository, CompanyRepository companyRepository) {
        this.tripRepository = tripRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Trip> get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        return tripRepository.findById(id);
    }

    @Override
    public Set<Trip> getAll() {
        Set<Trip> trips = new HashSet<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    @Override
    public List<Trip> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 0 || sortKeys == null) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(sortKeys));
        return tripRepository.findAll(pageRequest).toList();
    }

    @Override
    public Optional<Trip> create(Trip trip) {
        if (trip == null) throw new IllegalArgumentException("trip cannot be null");
        return Optional.of(tripRepository.save(trip));
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
            Company company = companyRepository.findById(Long.parseLong(data[0].trim())).orElse(null);
            if (company != null)
                tripRepository.save(new Trip(company, LocalDateTime.parse(data[1].trim()),
                        LocalDateTime.parse(data[2].trim()), data[3].trim(), data[4].trim()));
            else System.err.println("company by id " + data[0] + " not found!");
        }
    }

    @Override
    public Set<Passenger> getTripPassengers(Trip trip) {
        if (trip == null) throw new IllegalArgumentException("trip cannot be null");
        return new HashSet<>(tripRepository.findById(trip.getId())
                .map(Trip::getPassengers)
                .orElseGet(Collections::emptySet));
    }

    @Override
    public Optional<Trip> edit(Trip trip) {
        if (trip == null) throw new IllegalArgumentException("trip cannot be null");
        return Optional.of(tripRepository.save(trip));
    }

    @Override
    public void remove(Trip trip) {
        tripRepository.delete(trip);
    }

    @Override
    public void removeById(Long tripId) {
        if (tripId < 1) throw new IllegalArgumentException("id cannot be less than 1");
        tripRepository.deleteById(tripId);
    }

    @Override
    public List<Trip> getTripsFromCity(String fromCity) {
        if (fromCity == null) throw new IllegalArgumentException("fromCity cannot be null");
        return tripRepository.getAllByFromCity(fromCity);
    }

    @Override
    public List<Trip> getTripsToCity(String toCity) {
        if (toCity == null) throw new IllegalArgumentException("toCity cannot be null");
        return tripRepository.getAllByToCity(toCity);
    }

}
