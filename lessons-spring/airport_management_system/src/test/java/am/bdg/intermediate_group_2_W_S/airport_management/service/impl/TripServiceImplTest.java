package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Company;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class TripServiceImplTest {

    private TripService tripService;
    private CompanyService companyService;

    @Autowired
    TripServiceImplTest(TripService tripService, CompanyService companyService) {
        this.tripService = tripService;
        this.companyService = companyService;
    }


    @Test
    void getTrip() {
        Optional<Trip> optionalTrip = tripService.get(5L);
        optionalTrip.ifPresentOrElse(trip -> assertEquals(5, trip.getId()),
                Assertions::fail);
    }

    @Test
    void findAll() {
        Set<Trip> trips = tripService.getAll();
        assertFalse(trips.isEmpty());
    }

    @Test
    void getTrips() {
        List<Trip> trips = tripService.getCertainCrowd(2, 0, "toCity");
        assertEquals(2, trips.size());
    }

    @Test
    void create() {
        Company company = companyService.get(87L).orElse(null);
        assertNotNull(company);

        Trip trip = new Trip(company, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                "Braga", "Tallin");
        trip = tripService.create(trip).orElse(null);
        assertNotNull(trip);

        trip = tripService.get(trip.getId()).orElse(null);
        assertNotNull(trip);

        assertEquals("Tallin", trip.getToCity());
    }

    @Test
    void edit() {
        Optional<Trip> optionalTrip = tripService.get(6L);
        optionalTrip.ifPresent(trip -> {
            trip.setFromCity("Seltic");
            tripService.edit(trip);
        });
        optionalTrip = tripService.get(6L);
        optionalTrip.ifPresentOrElse(trip -> assertEquals("Seltic", trip.getFromCity()),
                Assertions::fail);
    }

    @Test
    void remove() {
        Optional<Trip> optionalTrip = tripService.get(7L);
        optionalTrip.ifPresent(trip -> tripService.removeById(trip.getId()));
        optionalTrip = tripService.get(7L);
        assertNull(optionalTrip.orElse(null));
    }

    @Test
    void getTripsFromCity() {
        List<Trip> trips = tripService.getTripsFromCity("Paris");
        trips.forEach(trip -> assertEquals("Paris", trip.getFromCity()));
    }

    @Test
    void getTripsToCity() {
        List<Trip> trips = tripService.getTripsToCity("Monaco");
        trips.forEach(trip -> assertEquals("Monaco", trip.getToCity()));
    }

    @Test
    void getPassengerTrips() {
        Trip trip = tripService.get(1L).orElse(null);
        assertNotNull(trip);
        Set<Passenger> passengers = tripService.getTripPassengers(trip);
        passengers.forEach(passenger -> assertTrue(passenger.getTrips().stream()
                .anyMatch(trip1 -> trip.getId() == 1L)));
    }
}
