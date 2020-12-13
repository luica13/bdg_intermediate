import service.CompanyService;
import service.PassengerService;
import service.TripService;
import service.impl.CompanyServiceFactory;
import service.impl.PassengerServiceFactory;
import service.impl.TripServiceFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hibernate_JPA");
        final EntityManager em = emf.createEntityManager();
        CompanyService companyService = new CompanyServiceFactory().getInstance(em);
        PassengerService passengerService = new PassengerServiceFactory().getInstance(em);
        TripService tripService = new TripServiceFactory().getInstance(em);
        companyService.loadCompaniesInfoFromFileAndCreateAll("root_resource/companies.txt");
        passengerService.loadPassengersInfoFromFileAndCreateAll("root_resource/passengers.txt");
        tripService.loadTripsInfoFromFileAndCreateAll("root_resource/trips.txt");
        passengerService.loadPassengersTripsInfoFromFile("root_resource/passengers_trips.txt");

    }
}
