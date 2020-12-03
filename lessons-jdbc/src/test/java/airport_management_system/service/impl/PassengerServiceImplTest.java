package airport_management_system.service.impl;

import airport_management_system.dao.impl.PassengerDAOImpl;
import airport_management_system.model.Address;
import airport_management_system.model.Passenger;
import airport_management_system.service.PassengerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImplTest {

    private static PassengerService service;

    @BeforeAll
    static void setUp() {
        service = new PassengerServiceImpl(new PassengerDAOImpl());
    }

    @Test
    void getCompanyById() {
        Optional<Passenger> passenger = service.get(456);
        if (passenger.isPresent()) assertEquals(456, passenger.get().getId());
        else Assertions.fail();
    }

    @Test
    void findAll() {
        Set<Passenger> passengers = service.findAll();
        assertFalse(passengers.isEmpty());
    }

    @Test
    void testGetCompanyBySortingAndPaging() {
        List<Passenger> passengers = service.getPassengers(20, 34, "founding_date");
        assertEquals(20, passengers.size());
        assertEquals(35, passengers.get(0).getId());
    }

    @Test
    void create() {
        Optional<Passenger> passenger = service.create(new Passenger("Teo Walcott", "1-2243-4646-6655",
                        new Address("England", "Chelsea")));
        if (passenger.isPresent()) {
            passenger = service.get(passenger.get().getId());
            if (passenger.isPresent()) {
                assertEquals("Teo Walcott", passenger.get().getName());
                assertEquals("Chelsea", passenger.get().getAddress().getCity());
            } else Assertions.fail();
        } else Assertions.fail();
    }

    @Test
    void edit() {
        final String newName = "Therry Anry";
        final int id = 210;
        Optional<Passenger> passenger = service.get(id);
        passenger.ifPresent(p -> {
            p.setName(newName);
            service.edit(p);
        });
        if (passenger.isPresent()) {
            passenger = service.get(passenger.get().getId());
            if (passenger.isPresent()) assertEquals(newName, passenger.get().getName());
            else Assertions.fail();
        } else Assertions.fail();
    }


    @Test
    void remove() {
        final int id = 675;
        Optional<Passenger> passenger = service.get(id);
        assertNotNull(passenger.orElse(null));
        service.remove(id);
        assertNull(service.get(id).orElse(null));
    }

    @Test
    void getPassengers_by_trip_id() {
        Set<Passenger> passengers = service.getPassengersOfTrip(3);
        assertFalse(passengers.isEmpty());
    }

}
