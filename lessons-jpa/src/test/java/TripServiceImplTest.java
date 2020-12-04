import dao.impl.CompanyDAOImpl;
import dao.impl.TripDAOImpl;
import entity.Company;
import entity.Passenger;
import entity.Trip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.TripService;
import service.impl.CompanyServiceImpl;
import service.impl.TripServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceImplTest {

    private static TripService service;
    private static EntityManager em;

    @BeforeAll
    static void setUp() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
        em = emf.createEntityManager();
        service = new TripServiceImpl(new TripDAOImpl(em));
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
        List<Trip> trips = service.getTrips(2, 4, "from_city");
        assertEquals(2, trips.size());
        assertTrue(trips.get(0).getFromCity().startsWith("A"));
    }

    @Test
    void create() {
        Optional<Company> optionalCompany = new CompanyServiceImpl(new CompanyDAOImpl(em)).getCompany(87);
        optionalCompany.ifPresent(company -> {
            Trip trip = new Trip(company, LocalDateTime.now(), LocalDateTime.now().plusHours(2),
                    "Braga", "Tallin");
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
        List<Trip> trips = service.getTripsFromCity("Paris");
        trips.forEach(trip -> assertEquals("Paris", trip.getFromCity()));
    }

    @Test
    void getTripsToCity() {
        List<Trip> trips = service.getTripsToCity("Monaco");
        trips.forEach(trip -> assertEquals("Monaco", trip.getToCity()));
    }

    @Test
    void getPassengerTrips() {
        Set<Trip> passengerTrips = service.getPassengerTrips(1);
        passengerTrips.forEach(trip -> assertTrue(trip.getPassengers().stream()
                .anyMatch(passenger -> passenger.getId() == 1)));
    }

    @Test
    void getTripPassengers() {
        Set<Passenger> tripPassengers = service.getTripPassengers(8);
        tripPassengers.forEach(passenger -> assertTrue(
                passenger.getTrips().stream().anyMatch(trip -> trip.getId() == 8)));
    }
}
