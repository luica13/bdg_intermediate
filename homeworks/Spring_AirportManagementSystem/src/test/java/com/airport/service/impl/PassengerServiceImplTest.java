package com.airport.service.impl;

import com.airport.AirportManagementSystemApp;
import com.airport.entity.Address;
import com.airport.entity.Passenger;
import com.airport.service.AddressService;
import com.airport.service.PassengerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {AirportManagementSystemApp.class})
class PassengerServiceImplTest {
    private PassengerService passengerService;
    private AddressService addressService;

    @Autowired
    public PassengerServiceImplTest(PassengerService passengerService, AddressService addressService) {
        this.passengerService = passengerService;
        this.addressService = addressService;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getById() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
        passengerService.save(new Passenger("Gevor","016546654",new Address("Armenia","baqu")));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getPassengersOfTrip() {
    }
}