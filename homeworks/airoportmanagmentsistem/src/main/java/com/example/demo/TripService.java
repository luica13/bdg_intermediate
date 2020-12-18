package com.example.demo;

public interface TripService {
        boolean create(long passengerId, long tripId);

        void loadPassengersTripsInfoFromFileAndCreateAll(String path);

        boolean remove(long passengerId, long tripId);
}
