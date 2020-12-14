import am.bdg.intermediate_group_2_W_S.airport_management.AirportManagementSystemApp;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Address;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Passenger;
import am.bdg.intermediate_group_2_W_S.airport_management.entity.Trip;
import am.bdg.intermediate_group_2_W_S.airport_management.service.AddressService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
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
        Passenger passenger = passengerService.get(1L).orElse(new Passenger());
        assertEquals(1, passenger.getId());
    }

    @Test
    void findAll() {
        Set<Passenger> passengers = passengerService.getAll();
        assertFalse(passengers.isEmpty());
    }

    @Test
    void getPassengers() {
        List<Passenger> passengerSubSet = passengerService.getCertainCrowd(30, 1, "name");
        assertEquals(30, passengerSubSet.size());
        assertTrue(passengerSubSet.get(0).getName().startsWith("A"));
    }

    @Test
    void create() {
        Address address = addressService.get(6L).orElse(null);
        assertNotNull(address);

        Optional<Passenger> optionalPassenger = passengerService.create(new Passenger("Harry", "+1-122-453-44-43", address));
        optionalPassenger.ifPresentOrElse(passenger -> {
            Optional<Passenger> optional = passengerService.get(passenger.getId());
            optional.ifPresentOrElse(
                    passenger1 -> assertEquals("Harry", passenger1.getName()),
                    Assertions::fail
            );
        }, Assertions::fail);
    }

    @Test
    void edit() {
        Optional<Passenger> optionalPassenger = passengerService.get(1L);
        optionalPassenger.ifPresent(p -> {
            p.setName("Teodor");
            passengerService.edit(p);
        });
        Passenger passenger = passengerService.get(1L).orElse(new Passenger());
        assertEquals("Teodor", passenger.getName());
    }

    @Test
    void remove() {
        Optional<Passenger> optionalPassenger = passengerService.get(156L);
        optionalPassenger.ifPresent(p -> passengerService.removeById(p.getId()));
        assertNull(passengerService.get(156L).orElse(null));
    }

    @Test
    void getPassengersOfTrip() {
        Optional<Passenger> optional = passengerService.get(1L);
        optional.ifPresentOrElse(passenger -> {
            Set<Trip> trips = passengerService.getTripsOfPassenger(passenger);
            for (Trip trip : trips)
                assertTrue(trip.getPassengers().stream()
                        .anyMatch(p -> p.getId() == 1L));
        }, Assertions::fail);

    }

    @Test
    void registerTrip() {
        Passenger passenger = passengerService.get(6L).orElse(null);
        assertNotNull(passenger);

        Trip trip = tripService.get(7L).orElse(null);
        assertNotNull(trip);
        String fromCity = trip.getFromCity();

        passengerService.registerTrip(trip, passenger);

        passenger = passengerService.get(passenger.getId()).orElse(null);
        assertNotNull(passenger);

        assertTrue(passenger.getTrips().stream()
                .anyMatch(t -> t.getFromCity().equals(fromCity)));
    }

    @Test
    void cancelTrip() {
        Trip trip = tripService.get(7L).orElse(null);
        Passenger passenger = passengerService.get(87L).orElse(null);
        passengerService.cancelTrip(trip, passenger);
        assertNotNull(trip);
        assertNotNull(passenger);
        Set<Trip> trips = passengerService.getTripsOfPassenger(passenger);
        trips.forEach(trip1 -> assertNotEquals(87, trip1.getId()));
    }
}
