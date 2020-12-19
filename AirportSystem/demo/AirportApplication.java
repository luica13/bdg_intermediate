package com.bdg.demo;

import com.bdg.demo.airportMgmtJPA.service.CompanyService;
import com.bdg.demo.airportMgmtJPA.service.PassengerService;
import com.bdg.demo.airportMgmtJPA.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AirportApplication {

	private CompanyService companyService;
	private PassengerService passengerService;
	private TripService tripService;

	@Autowired
	public AirportApplication(CompanyService companyService,
									  PassengerService passengerService,
									  TripService tripService) {
		this.companyService = companyService;
		this.passengerService = passengerService;
		this.tripService = tripService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

	@PostConstruct
    public void loadDataFromFile() {
        companyService.loadEntitiesInfoFromFileAndCreateAll("root_resource/companies.txt");
        passengerService.loadEntitiesInfoFromFileAndCreateAll("root_resource/passengers.txt");
        tripService.loadEntitiesInfoFromFileAndCreateAll("root_resource/trips.txt");
        passengerService.loadPassengersTripsInfoFromFile("root_resource/passengers_trips.txt");
    }

}
