package com.bdg.models;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String plane;
    private String townTo;
    private LocalTime flightTime;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Schedule(String companyName, String plane, String townTo, LocalTime flightTime) {
        this.companyName = companyName;
        this.plane = plane;
        this.townTo = townTo;
        this.flightTime = flightTime;
    }

    public Schedule(Long id, String companyName, String plane, String townTo, LocalTime flightTime, Employee employee) {
        this.id = id;
        this.companyName = companyName;
        this.plane = plane;
        this.townTo = townTo;
        this.flightTime = flightTime;
        this.employee = employee;
    }

    public Schedule(String companyName, String plane, String townTo, LocalTime flightTime, Employee employee) {
        this.companyName = companyName;
        this.plane = plane;
        this.townTo = townTo;
        this.flightTime = flightTime;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
