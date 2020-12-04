import dao.impl.CompanyDAOImpl;
import dao.impl.PassengerDAOImpl;
import dao.impl.TripDAOImpl;
import service.CompanyService;
import service.PassengerService;
import service.TripService;
import service.impl.CompanyServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TripServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
        final EntityManager em = emf.createEntityManager();
        CompanyService companyService = new CompanyServiceImpl(new CompanyDAOImpl(em));
        PassengerService passengerService = new PassengerServiceImpl(new PassengerDAOImpl(em));
        TripService tripService = new TripServiceImpl(new TripDAOImpl(em));
        companyService.loadCompaniesInfoFromFileAndCreateAll("root_resource/companies.txt");
        passengerService.loadPassengersInfoFromFileAndCreateAll("root_resource/passengers.txt");
        tripService.loadTripsInfoFromFileAndCreateAll("root_resource/trips.txt");
        passengerService.loadPassengersTripsInfoFromFile("root_resource/passengers_trips.txt");

    }
}
