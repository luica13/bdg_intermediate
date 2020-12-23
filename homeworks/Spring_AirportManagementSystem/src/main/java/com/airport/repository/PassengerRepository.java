package com.airport.repository;

import com.airport.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    ////Luiza
    @Query("select c from Passenger c INNER join Ticket on Passenger.id=Ticket.passenger.id INNER join Trip on Ticket.trip.tripNumber=Trip.tripNumber where Trip.tripNumber=?1")
    List<Passenger> getPassengersOfTrip(Long tripNumber);
}
