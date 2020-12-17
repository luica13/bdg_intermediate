package com.airport.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String country;

    @Column
    private String city;


    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

}
