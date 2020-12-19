package com.bdg.demo.airportMgmtJPA.service.model;

import com.bdg.demo.airportMgmtJPA.entity.Company;
import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Data
public class TripDto {

    private long id;

    private String company;

    private LocalDate time_in;

    private LocalDate time_out;

    private String from_city;

    private String to_city;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Passenger> passengers;

    public TripDto(long id, Company company, LocalDateTime timeIn, LocalDateTime timeOut, LocalDateTime timeOut1) {
    }

    public TripDto(long id, Company company, LocalDateTime timeIn, LocalDateTime timeOut, String fromCity, String toCity) {
    }
}
