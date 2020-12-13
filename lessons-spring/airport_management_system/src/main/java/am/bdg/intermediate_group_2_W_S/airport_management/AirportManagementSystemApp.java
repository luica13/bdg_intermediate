package am.bdg.intermediate_group_2_W_S.airport_management;

import am.bdg.intermediate_group_2_W_S.airport_management.service.CompanyService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.PassengerService;
import am.bdg.intermediate_group_2_W_S.airport_management.service.TripService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AirportManagementSystemApp {

    private final CompanyService companyService;
    private final PassengerService passengerService;
    private final TripService tripService;

    public AirportManagementSystemApp(CompanyService companyService,
                                      PassengerService passengerService,
                                      TripService tripService) {
        this.companyService = companyService;
        this.passengerService = passengerService;
        this.tripService = tripService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AirportManagementSystemApp.class, args);
    }

    @PostConstruct
    public void loadDataFromFile() {
        companyService.loadEntitiesInfoFromFileAndCreateAll("root_resource/companies.txt");
        passengerService.loadEntitiesInfoFromFileAndCreateAll("root_resource/passengers.txt");
        tripService.loadEntitiesInfoFromFileAndCreateAll("root_resource/trips.txt");
        passengerService.loadPassengersTripsInfoFromFile("root_resource/passengers_trips.txt");
    }
}
