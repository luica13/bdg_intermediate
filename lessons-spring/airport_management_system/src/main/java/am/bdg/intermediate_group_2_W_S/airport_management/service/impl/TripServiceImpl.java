package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.CompanyRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.repository.TripRepository;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
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
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public TripDto get(Long id) {
        if (id < 1) throw new IllegalArgumentException("id cannot be less than 1");
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            Company company = trip.getCompany();
            return TripDto.builder()
                    .id(trip.getId())
                    .company(CompanyDto.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .foundingDate(company.getFoundingDate())
                            .build())
                    .fromCity(trip.getFromCity())
                    .toCity(trip.getToCity())
                    .timeIn(trip.getTimeIn())
                    .timeOut(trip.getTimeOut()).build();
        } else throw new EntityNotFoundException(String.format("trip by id: %s not found.", id));
    }

    @Override
    public Set<TripDto> getAll() {
        Set<TripDto> tripDtos = new HashSet<>();
        for (Trip trip : tripRepository.findAll()) {
            Company company = trip.getCompany();
            tripDtos.add(TripDto.builder()
                    .id(trip.getId())
                    .company(CompanyDto.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .foundingDate(company.getFoundingDate())
                            .build())
                    .fromCity(trip.getFromCity())
                    .toCity(trip.getToCity())
                    .timeIn(trip.getTimeIn())
                    .timeOut(trip.getTimeOut()).build());
        }
        return tripDtos;
    }

    @Override
    public List<TripDto> getCertainCrowd(int limit, int offset, String... sortKeys) {
        if (limit < 1 || offset < 0) throw new IllegalArgumentException("illegal argument present");
        PageRequest pageRequest = PageRequest.of(offset, limit);
        if (sortKeys != null && sortKeys.length != 0) pageRequest.getSortOr( Sort.by(sortKeys));
        return tripRepository.findAll(pageRequest).map(trip -> {
            Company company = trip.getCompany();
            return TripDto.builder()
                    .id(trip.getId())
                    .company(CompanyDto.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .foundingDate(company.getFoundingDate())
                            .build())
                    .fromCity(trip.getFromCity())
                    .toCity(trip.getToCity())
                    .timeIn(trip.getTimeIn())
                    .timeOut(trip.getTimeOut()).build();
        }).toList();
    }

    @Override
    public TripDto create(TripDto tripDto) {
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        Company company = new Company(tripDto.getCompany().getName(), tripDto.getCompany().getFoundingDate());
        company.setId(tripDto.getCompany().getId());
        Trip trip = new Trip(company, tripDto.getTimeIn(), tripDto.getTimeOut(), tripDto.getFromCity(), tripDto.getToCity());
        trip = tripRepository.save(trip);
        company = trip.getCompany();
        return TripDto.builder()
                .id(trip.getId())
                .company(CompanyDto.builder()
                        .id(company.getId())
                        .name(company.getName())
                        .foundingDate(company.getFoundingDate())
                        .build())
                .fromCity(trip.getFromCity())
                .toCity(trip.getToCity())
                .timeIn(trip.getTimeIn())
                .timeOut(trip.getTimeOut()).build();
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
    public Set<PassengerDto> getTripPassengers(TripDto tripDto) {
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        return tripRepository.findById(tripDto.getId())
                .map(Trip::getPassengers).get().stream()
                .map(passenger -> {
                    Address address = passenger.getAddress();
                    AddressDto addressDto = AddressDto.builder().id(address.getId()).country(address.getCountry()).city(address.getCity()).build();
                    return PassengerDto.builder()
                            .id(passenger.getId())
                            .address(addressDto)
                            .name(passenger.getName())
                            .phone(passenger.getPhone()).build();
                }).collect(Collectors.toSet());
    }

    @Override
    public TripDto edit(TripDto tripDto) {
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        Company company = new Company(tripDto.getCompany().getName(), tripDto.getCompany().getFoundingDate());
        company.setId(tripDto.getCompany().getId());
        Trip saved = tripRepository.save(new Trip(company, tripDto.getTimeIn(), tripDto.getTimeOut(), tripDto.getFromCity(), tripDto.getToCity()));
        company = saved.getCompany();
        return TripDto.builder()
                .id(saved.getId())
                .company(CompanyDto.builder()
                        .id(company.getId())
                        .name(company.getName())
                        .foundingDate(company.getFoundingDate())
                        .build())
                .timeOut(saved.getTimeOut())
                .timeIn(saved.getTimeIn())
                .toCity(saved.getToCity())
                .fromCity(saved.getFromCity()).build();
    }

    @Override
    public void remove(TripDto tripDto) {
        if (tripDto == null) throw new IllegalArgumentException("trip cannot be null");
        Company company = new Company(tripDto.getCompany().getName(), tripDto.getCompany().getFoundingDate());
        company.setId(tripDto.getCompany().getId());
        tripRepository.delete(new Trip(company, tripDto.getTimeIn(), tripDto.getTimeOut(), tripDto.getFromCity(), tripDto.getToCity()));
    }

    @Override
    public void removeById(Long tripId) {
        if (tripId < 1) throw new IllegalArgumentException("id cannot be less than 1");
        tripRepository.deleteById(tripId);
    }

    @Override
    public List<TripDto> getTripsFromCity(String fromCity) {
        if (fromCity == null) throw new IllegalArgumentException("fromCity cannot be null");
        return tripRepository.getAllByFromCity(fromCity).stream().map(trip -> {
            Company company = trip.getCompany();
            return TripDto.builder()
                    .id(trip.getId())
                    .company(CompanyDto.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .foundingDate(company.getFoundingDate())
                            .build())
                    .timeOut(trip.getTimeOut())
                    .timeIn(trip.getTimeIn())
                    .toCity(trip.getToCity())
                    .fromCity(trip.getFromCity()).build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<TripDto> getTripsToCity(String toCity) {
        if (toCity == null) throw new IllegalArgumentException("toCity cannot be null");
        return tripRepository.getAllByToCity(toCity).stream().map(trip -> {
            Company company = trip.getCompany();
            return TripDto.builder()
                    .id(trip.getId())
                    .company(CompanyDto.builder()
                            .id(company.getId())
                            .name(company.getName())
                            .foundingDate(company.getFoundingDate())
                            .build())
                    .timeOut(trip.getTimeOut())
                    .timeIn(trip.getTimeIn())
                    .toCity(trip.getToCity())
                    .fromCity(trip.getFromCity()).build();
        }).collect(Collectors.toList());
    }

}
