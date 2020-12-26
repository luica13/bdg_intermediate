package com.bdg.mvc.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Passenger {
    private Long id;

    private String city;
    private String country;
    private String name;
    private String phone;

    private List<Trip> trips;

    public Passenger(Long id, String city, String country, String name, String phone) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.name = name;
        this.phone = phone;
    }
}
