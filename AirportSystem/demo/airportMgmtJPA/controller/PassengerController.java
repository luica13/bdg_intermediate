package com.bdg.demo.airportMgmtJPA.controller;


import com.bdg.demo.airportMgmtJPA.entity.Company;
import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.repository.PassengerRepository;
import com.bdg.demo.airportMgmtJPA.service.PassengerService;
import com.bdg.demo.airportMgmtJPA.service.model.CompanyDto;
import com.bdg.demo.airportMgmtJPA.service.model.PassengerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
@RequiredArgsConstructor
public class PassengerController {

    @Autowired
    private final PassengerService passengerService;

    private PassengerRepository passengerRepository = null;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        PassengerDto passengerDto = null;
        try {
            passengerDto = passengerService.get(id);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @DeleteMapping("/passenger/{id}")
    public void deleteById(@PathVariable long id){
        PassengerDto passengerDto = null;
        passengerRepository.deleteById(id);
    }

    @PutMapping("/passenger/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Passenger passenger, @PathVariable long id) {

        Optional<Passenger> passengerOptional = passengerRepository.findById(id);

        if (!passengerOptional.isPresent())
            return ResponseEntity.notFound().build();

        passenger.setId(id);

        passengerRepository.save(passenger);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public PassengerDto create(@RequestBody @Valid Passenger passenger) {
        PassengerDto passengerDto = new PassengerDto(passenger.getId(), passenger.getName(),
                passenger.getPhone(), passenger.getCountry(),passenger.getCity());
        passengerDto = passengerService.create(passengerDto);
        return passengerDto;
    }

}

