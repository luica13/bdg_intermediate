package com.bdg.mvc.dao;

import com.bdg.mvc.models.Passenger;

import java.util.List;

public interface PassengerDao extends CrudDao<Passenger> {
    List<Passenger> findAllByFirstName(String firstName);

    Passenger findTravelerByCity(String city);
}
