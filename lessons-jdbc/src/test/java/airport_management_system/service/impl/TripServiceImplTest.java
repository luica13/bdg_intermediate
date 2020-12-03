package airport_management_system.service.impl;

import airport_management_system.dao.impl.CompanyDAOImpl;
import airport_management_system.dao.impl.TripDAOImpl;
import airport_management_system.model.Company;
import airport_management_system.model.Passenger;
import airport_management_system.model.Trip;
import airport_management_system.service.TripService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static airport_management_system.model.Trip.TripBuilder;

class TripServiceImplTest {

    private static TripService service;

    @BeforeAll
    static void setUp() {
        service = new TripServiceImpl(new TripDAOImpl());
    }

    @Test
    void getTrip() {
        Optional<Trip> optionalTrip = service.getTrip(5);
        if (optionalTrip.isPresent()) {
            assertEquals(5, optionalTrip.get().getId());
        } else Assertions.fail();
    }

    @Test
    void findAll() {
        Set<Trip> trips = service.findAll();
        assertFalse(trips.isEmpty());
    }

    @Test
    void getTrips() {
        List<Trip> trips = service.getTrips(2, 4, "time_in");
        assertEquals(2, trips.size());
        assertEquals(5, trips.get(0).getId());
    }

    @Test
    void create() {
        Optional<Company> optionalCompany = new CompanyServiceImpl(new CompanyDAOImpl()).getCompany(87);
        optionalCompany.ifPresent(company -> {
            Trip trip = new TripBuilder()
                    .company(company)
                    .timeIn(LocalDateTime.now())
                    .timeOut(LocalDateTime.now().plusHours(2))
                    .fromCity("Braga")
                    .toCity("Tallin")
                    .build();
            Optional<Trip> optionalTrip = service.create(trip);
            if (optionalTrip.isPresent()) {
                optionalTrip = service.getTrip(optionalTrip.get().getId());
                if (optionalTrip.isPresent()) assertEquals("Tallin", optionalTrip.get().getToCity());
                else Assertions.fail();
            } else Assertions.fail();
        });
    }

    @Test
    void edit() {
        Optional<Trip> optionalTrip = service.getTrip(6);
        optionalTrip.ifPresent(trip -> {
            trip.setFromCity("Seltic");
            service.edit(trip);
        });
        optionalTrip = service.getTrip(6);
        if (optionalTrip.isPresent()) assertEquals("Seltic", optionalTrip.get().getFromCity());
        else Assertions.fail();
    }

    @Test
    void remove() {
        Optional<Trip> optionalTrip = service.getTrip(7);
        optionalTrip.ifPresent(trip -> service.remove(trip.getId()));
        optionalTrip = service.getTrip(7);
        assertNull(optionalTrip.orElse(null));
    }

    @Test
    void getTripsFromCity() {
        List<Trip> trips = service.getTripsFromCity("Moscow");
        trips.forEach(trip -> assertEquals("Moscow", trip.getFromCity()));
    }

    @Test
    void getTripsToCity() {
        List<Trip> trips = service.getTripsToCity("Monaco");
        trips.forEach(trip -> assertEquals("Monaco", trip.getToCity()));
    }

    @Test
    void getPassengerTrips() {
        Set<Trip> passengerTrips = service.getPassengerTrips(1);
        passengerTrips.forEach(trip -> assertEquals(1, trip.getPassengers().stream().findAny()
                .orElse(new Passenger("", "", null))
                .getId()));
    }
}
