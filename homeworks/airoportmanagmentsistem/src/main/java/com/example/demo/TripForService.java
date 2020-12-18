package com.example.demo;

import java.util.List;
import java.util.Set;

public interface TripForService {
    TripForService getById(long id);
    Set<TripForService> getAll();
    Set<TripForService> get(int page, int perPage, String sort);
    TripForService save(TripForService passenger);
    TripForService update(TripForService passenger);
    void delete(long tripId);
    List<TripForService> getTripsFrom(String city);
    List<TripForService> getTripsTo(String city);
}
