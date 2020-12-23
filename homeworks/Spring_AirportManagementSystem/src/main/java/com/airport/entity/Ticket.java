package com.airport.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long number;
    @ManyToOne
    private Trip trip;
    @ManyToOne
    private Passenger passenger;

    public Ticket() {
    }


    public Ticket(Trip trip, Passenger passenger) {
        this.trip = trip;
        this.passenger = passenger;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    private static Ticket getByPassengerId_tripNumber(EntityManager em, long passengerId, long tripNumber)
    {
        Ticket ticket;
        List<Ticket> tickets = em.createQuery("select c from Ticket c where Ticket.passenger.id=:passengerId AND Ticket.trip.tripNumber=:tripNumber")
                .setParameter("passengerId", passengerId)
                .setParameter("tripNumber", tripNumber)
                .getResultList();
        if(tickets.isEmpty())
            return null;
        return tickets.get(0);
    }
}
