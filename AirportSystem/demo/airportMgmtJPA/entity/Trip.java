package com.bdg.demo.airportMgmtJPA.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Getter
@Setter
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @Column(name = "time_in")
    private LocalDateTime timeIn;

    @Column(name = "time_out")
    private LocalDateTime timeOut;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Trip(Company company, LocalDateTime timeIn, LocalDateTime timeOut, String fromCity, String toCity) {
        this.company = company;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public Trip() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id &&
                Objects.equals(company, trip.company) &&
                Objects.equals(timeIn, trip.timeIn) &&
                Objects.equals(timeOut, trip.timeOut) &&
                Objects.equals(fromCity, trip.fromCity) &&
                Objects.equals(toCity, trip.toCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, timeIn, timeOut, fromCity, toCity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Trip.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("company=" + company)
                .add("timeIn=" + timeIn)
                .add("timeOut=" + timeOut)
                .add("fromCity='" + fromCity + "'")
                .add("toCity='" + toCity + "'")
                .toString();
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REMOVE
    },
            fetch = FetchType.EAGER)
    @JoinTable(name = "passenger_trip",
            joinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id", referencedColumnName = "id"))
    private Set<Passenger> passengers;
}