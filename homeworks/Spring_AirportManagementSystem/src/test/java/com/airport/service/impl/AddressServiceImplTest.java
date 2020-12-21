package com.airport.service.impl;

import com.airport.AirportManagementSystemApp;
import com.airport.entity.Address;
import com.airport.service.AddressService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {AirportManagementSystemApp.class})
class AddressServiceImplTest {

    private final AddressService addressService;

    @Autowired
    public AddressServiceImplTest(AddressService addressService) {
        this.addressService = addressService;
    }

    @BeforeAll
    static void beforeAll() {
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
        addressService.save(new Address("Armenia","Yerevan"));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}