package com.airport.entity;

import com.airport.service.impl.CommonService;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String name;
    private String passengerPhone;
    @ManyToOne
    @JoinColumn(name = "AddressId")
    private Address address;

    public Passenger() {
    }

    public Passenger(String name, String passengerPhone, Address address) {
        this.name = name;
        this.passengerPhone = passengerPhone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
