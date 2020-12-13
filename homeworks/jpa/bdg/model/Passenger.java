package com.bdg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pass_id;

    private String name;
    private String phone;
    private String country;
    private String city;

    public Passenger() {
    }

    public Passenger(String name, String phone, String country, String city) {
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    public Passenger(Long pass_id, String name, String phone, String country, String city) {
        this.pass_id = pass_id;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Passenger[" +
                "pass_id=" + pass_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ']';
    }
}
