import dao.impl.CompanyDAOImpl;
import dao.impl.PassengerDAOImpl;
import dao.impl.TripDAOImpl;
import entity.Address;
import entity.Company;
import entity.Passenger;
import entity.Trip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.PassengerService;
import service.TripService;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImplTest {

    private static PassengerService passengerService;
    private static TripService tripService;
    private static EntityManager em;

    @BeforeAll
    static void setUpDao() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
        em = emf.createEntityManager();
        passengerService = new PassengerServiceImpl(new PassengerDAOImpl(em));
        tripService = new TripServiceImpl(new TripDAOImpl(em));
    }

    @Test
    void get() {
        Passenger passenger = passengerService.get(1).orElse(new Passenger());
        assertEquals(1, passenger.getId());
    }

    @Test
    void findAll() {
        Set<Passenger> passengers = passengerService.findAll();
        assertFalse(passengers.isEmpty());
    }

    @Test
    void getPassengers() {
        List<Passenger> passengerSubSet = passengerService.getPassengers(30, 1, "name");
        assertEquals(30, passengerSubSet.size());
    }

    @Test
    void create() {
        Optional<Passenger> optionalPassenger = passengerService.create(new Passenger("Harry", "+1-122-453-44-43", new Address("US", "LA")));
        if (optionalPassenger.isPresent()) {
            optionalPassenger = passengerService.get(optionalPassenger.get().getId());
            if (optionalPassenger.isPresent()) assertEquals("Harry", optionalPassenger.get().getName());
            else Assertions.fail();
        } else Assertions.fail();
    }

    @Test
    void edit() {
        Optional<Passenger> optionalPassenger = passengerService.get(1);
        optionalPassenger.ifPresent(p -> {
            p.setName("Teodor");
            passengerService.edit(p);
        });
        Passenger passenger = passengerService.get(1).orElse(new Passenger());
        assertEquals("Teodor", passenger.getName());
    }

    @Test
    void remove() {
        Optional<Passenger> optionalPassenger = passengerService.get(1);
        optionalPassenger.ifPresent(p -> passengerService.remove(p.getId()));
        assertNull(passengerService.get(1).orElse(null));
    }

    @Test
    void getPassengersOfTrip() {
        Set<Passenger> passengers = passengerService.getPassengersOfTrip(5);
        for (Passenger passenger: passengers) {
            assertEquals(5, passenger.getTrips().stream().findAny().orElse(new Trip()).getId());
        }
    }

    @Test
    void registerTrip() {
        Passenger passenger = new Passenger("Adam", "+22-122-45-44-32", new Address("Canada", "Ottava"));
        passenger = passengerService.create(passenger).orElse(new Passenger());
        Company company = new Company("AirLane", LocalDate.of(1996, 4, 6));
        company = new CompanyServiceImpl(new CompanyDAOImpl(em)).create(company).orElse(new Company());
        Trip trip = new Trip(company, LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Yalta", "Sofia");
        trip = tripService.create(trip).orElse(new Trip());
        passengerService.registerTrip(trip, passenger);
        passenger = passengerService.get(passenger.getId()).orElse(new Passenger());
        assertEquals("Yalta", passenger.getTrips().stream().findFirst().orElse(new Trip()).getFromCity());
    }

    @Test
    void cancelTrip() {
        passengerService.cancelTrip(87, 7);
        Set<Passenger> passengers = passengerService.getPassengersOfTrip(7);
        passengers.forEach(passenger -> assertNotEquals(87, passenger.getId()));
    }
}
