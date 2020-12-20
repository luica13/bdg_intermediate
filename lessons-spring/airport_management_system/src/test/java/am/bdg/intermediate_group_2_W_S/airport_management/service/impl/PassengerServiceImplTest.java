package am.bdg.intermediate_group_2_W_S.airport_management.service.impl;

import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.AddressDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.PassengerDto;
import am.bdg.intermediate_group_2_W_S.airport_management.service.dto.TripDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class PassengerServiceImplTest {

    private PassengerService passengerService;
    private TripService tripService;
    private AddressService addressService;

    @Autowired
    PassengerServiceImplTest(PassengerService passengerService, TripService tripService, AddressService addressService) {
        this.passengerService = passengerService;
        this.tripService = tripService;
        this.addressService = addressService;
    }

    @Test
    void get() {
        PassengerDto passenger = passengerService.get(1L);
        assertNotNull(passenger);
        assertEquals(1, passenger.getId());
    }

    @Test
    void findAll() {
        Set<PassengerDto> passengers = passengerService.getAll();
        assertFalse(passengers.isEmpty());
    }

    @Test
    void getPassengers() {
        List<PassengerDto> passengerSubSet = passengerService.getCertainCrowd(30, 1, "name");
        assertEquals(30, passengerSubSet.size());
    }

    @Test
    void create() {
        AddressDto address = addressService.get(6L);
        assertNotNull(address);

        PassengerDto passengerDto = passengerService.create(PassengerDto.builder()
                .name("Harry")
                .phone("+1-122-453-44-43")
                .address(AddressDto.builder()
                        .id(address.getId())
                        .city(address.getCity())
                        .country(address.getCountry()).build())
                .build());
        assertNotNull(passengerDto);

        passengerDto = passengerService.get(passengerDto.getId());
        assertNotNull(passengerDto);
        assertEquals("Harry", passengerDto.getName());
    }

    @Test
    void edit() {
        PassengerDto passenger = passengerService.get(1L);
        assertNotNull(passenger);

        passenger.setName("Teodor");
        passenger = passengerService.edit(passenger);
        assertNotNull(passenger);

        passenger = passengerService.get(1L);
        assertNotNull(passenger);
        assertEquals("Teodor", passenger.getName());
    }

    @Test
    void removeById() {
        PassengerDto passenger = passengerService.get(156L);
        assertNotNull(passenger);

        passengerService.removeById(passenger.getId());
        assertThrows(EntityNotFoundException.class, () -> passengerService.get(156L));
    }

    @Test
    void remove() {
        PassengerDto passenger = passengerService.get(100L);
        assertNotNull(passenger);

        passengerService.remove(passenger);
        assertThrows(EntityNotFoundException.class, () -> passengerService.get(100L));
    }

    @Test
    void getPassengersOfTrip() {
        PassengerDto passenger = passengerService.get(1L);
        assertNotNull(passenger);

        Set<TripDto> tripsOfPassenger = passengerService.getTripsOfPassenger(passenger);
        for (TripDto trip : tripsOfPassenger)
            assertTrue(trip.getPassengers().stream()
                    .anyMatch(p -> p.getId() == 1L));
    }

    @Test
    void registerTrip() {
        PassengerDto passenger = passengerService.get(45L);
        assertNotNull(passenger);

        TripDto trip = tripService.get(7L);
        assertNotNull(trip);
        String fromCity = trip.getFromCity();

        passengerService.registerTrip(trip, passenger);

        passenger = passengerService.get(passenger.getId());
        assertNotNull(passenger);

        assertTrue(passenger.getTrips().stream()
                .anyMatch(t -> t.getFromCity().equals(fromCity)));
    }

    @Test
    void cancelTrip() {
        TripDto trip = tripService.get(7L);
        PassengerDto passenger = passengerService.get(87L);
        assertNotNull(trip);
        assertNotNull(passenger);
        passengerService.cancelTrip(trip, passenger);
        Set<TripDto> trips = passengerService.getTripsOfPassenger(passenger);
        trips.forEach(trip1 -> assertNotEquals(87, trip1.getId()));
    }
}
