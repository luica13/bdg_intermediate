package com.bdg.demo.airportMgmtJPA.controller.model;

import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Data
public class Trip {

    private long id;

    private String company;

    private LocalDate time_in;

    private LocalDate time_out;

    private String from_city;

    private String to_city;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Passenger> passengers;
}
