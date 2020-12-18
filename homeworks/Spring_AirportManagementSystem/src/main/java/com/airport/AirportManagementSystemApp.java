package com.airport;

import com.airport.service.CompanyService;
import com.airport.service.PassengerService;
import com.airport.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportManagementSystemApp {

    private CompanyService companyService;
    private PassengerService passengerService;
    private TripService tripService;

    @Autowired
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
}