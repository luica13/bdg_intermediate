import airport_management_system.dao.impl.CompanyDAOImpl;
import airport_management_system.dao.impl.PassengerDAOImpl;
import airport_management_system.dao.impl.PassengerTripDAOImpl;
import airport_management_system.dao.impl.TripDAOImpl;
import airport_management_system.service.CompanyService;
import airport_management_system.service.PassengerService;
import airport_management_system.service.PassengerTripService;
import airport_management_system.service.TripService;
import airport_management_system.service.impl.CompanyServiceImpl;
import airport_management_system.service.impl.PassengerServiceImpl;
import airport_management_system.service.impl.PassengerTripServiceImpl;
import airport_management_system.service.impl.TripServiceImpl;

public class Main {
    public static void main(String[] args) {
        CompanyService companyService = new CompanyServiceImpl(new CompanyDAOImpl());
        PassengerService passengerService = new PassengerServiceImpl(new PassengerDAOImpl());
        TripService tripService = new TripServiceImpl(new TripDAOImpl());
        PassengerTripService passengerTripService = new PassengerTripServiceImpl(new PassengerTripDAOImpl());
        companyService.loadCompaniesInfoFromFileAndCreateAll("lessons-jdbc/src/main/resources/companies.txt");
        passengerService.loadPassengersInfoFromFileAndCreateAll("lessons-jdbc/src/main/resources/passengers.txt");
        tripService.loadTripsInfoFromFileAndCreateAll("lessons-jdbc/src/main/resources/trips.txt");
        passengerTripService.loadPassengersTripsInfoFromFileAndCreateAll("lessons-jdbc/src/main/resources/passengers_trips.txt");
    }
}
