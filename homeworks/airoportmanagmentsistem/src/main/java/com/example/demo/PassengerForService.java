package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PassengerForService {
        Optional<PassengerForService> get(long id);

        Set<PassengerForService> findAll();

        List<PassengerForService> getPassengers(int page, int perPage, String sort);

        Optional<PassengerForService> create(PassengerForService passenger);

        void loadPassengersInfoFromFileAndCreateAll(String path);

        Optional<PassengerForService> edit(PassengerForService passenger);

        void remove(long passengerId);

        Set<PassengerForService> getPassengersOfTrip(long tripNumber);

        void registerTrip(TripForService trip, PassengerForService passenger);

        void cancelTrip(long passengerId, long tripNumber);
}
