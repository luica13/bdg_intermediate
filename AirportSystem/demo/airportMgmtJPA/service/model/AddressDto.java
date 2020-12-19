package com.bdg.demo.airportMgmtJPA.service.model;

import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Data
public class AddressDto {

    private long id;

    private String country;

    private String city;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Passenger> passengers;
}
