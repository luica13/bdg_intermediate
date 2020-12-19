package com.bdg.demo.airportMgmtJPA.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;


@AllArgsConstructor
@Data
public class Passenger {
    private long id;

    private String name;

    private String phone;

    private String country;

    private String city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Trip> trips;
}
