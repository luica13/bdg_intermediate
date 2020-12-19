package com.bdg.demo.airportMgmtJPA.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;


@AllArgsConstructor
@Data
public class PassengerDto {
    private long id;

    private String name;

    private String phone;

    private String country;

    private String city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TripDto> trips;

    public PassengerDto(long id, String name, String phone, String country, String city) {
    }
}
