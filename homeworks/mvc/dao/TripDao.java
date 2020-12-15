package com.bdg.mvc.dao;

import com.bdg.mvc.models.Trip;

import java.util.List;

public interface TripDao extends CrudDao<Trip> {
    List<Trip> findByPlane(String plane);
}
