package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.CompanyDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
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
        TripDto trip = tripService.get(5L);
        assertNotNull(trip);
        assertEquals(5, trip.getId());
    }

    @Test
    void findAll() {
        Set<TripDto> trips = tripService.getAll();
        assertFalse(trips.isEmpty());
    }

    @Test
    void getTrips() {
        List<TripDto> trips = tripService.getCertainCrowd(2, 0, "toCity");
        assertEquals(2, trips.size());
    }

    @Test
    void create() {
        CompanyDto company = companyService.get(87L);
        assertNotNull(company);

        TripDto trip = tripService.create(TripDto.builder()
                .company(company)
                .timeOut(LocalDateTime.now())
                .timeIn(LocalDateTime.now().plusHours(2))
                .fromCity("Braga")
                .toCity("Tallin").build());
        assertNotNull(trip);

        trip = tripService.get(trip.getId());
        assertNotNull(trip);

        assertEquals("Tallin", trip.getToCity());
    }

    @Test
    void edit() {
        TripDto trip = tripService.get(6L);
        assertNotNull(trip);

        trip.setFromCity("Seltic");
        trip = tripService.edit(trip);
        assertNotNull(trip);

        trip = tripService.get(6L);
        assertNotNull(trip);
        assertEquals("Seltic", trip.getFromCity());
    }

    @Test
    void remove() {
        TripDto trip = tripService.get(7L);
        assertNotNull(trip);

        tripService.removeById(trip.getId());

        assertThrows(EntityNotFoundException.class, () -> tripService.get(7L));
    }

    @Test
    void getTripsFromCity() {
        List<TripDto> trips = tripService.getTripsFromCity("Paris");
        trips.forEach(trip -> assertEquals("Paris", trip.getFromCity()));
    }

    @Test
    void getTripsToCity() {
        List<TripDto> trips = tripService.getTripsToCity("Monaco");
        trips.forEach(trip -> assertEquals("Monaco", trip.getToCity()));
    }

    @Test
    void getPassengerTrips() {
        TripDto trip = tripService.get(5L);
        assertNotNull(trip);

        Set<PassengerDto> passengers = tripService.getTripPassengers(trip);
        passengers.forEach(passenger -> assertTrue(passenger.getTrips().stream()
                .anyMatch(trip1 -> trip.getId() == 5L)));
    }
}
