package com.bdg.demo.airportMgmtJPA.controller;

import com.bdg.demo.airportMgmtJPA.entity.Passenger;
import com.bdg.demo.airportMgmtJPA.entity.Trip;
import com.bdg.demo.airportMgmtJPA.repository.TripRepository;
import com.bdg.demo.airportMgmtJPA.service.TripService;
import com.bdg.demo.airportMgmtJPA.service.model.PassengerDto;
import com.bdg.demo.airportMgmtJPA.service.model.TripDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {

    @Autowired
    private final TripService tripService;


    private TripRepository tripRepository = null;
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable final Long id) {
        TripDto tripDto = null;
        try {
            tripDto = tripService.get(id);
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
        return new ResponseEntity<>(tripDto, HttpStatus.OK);
    }

    @DeleteMapping("/trip/{id}")
    public void deleteById(@PathVariable long id){
        PassengerDto passengerDto = null;
        tripRepository.deleteById(id);
    }

    @PutMapping("/trip/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Trip trip, @PathVariable long id) {

        Optional<Trip> tripOptional = tripRepository.findById(id);

        if (!tripOptional.isPresent())
            return ResponseEntity.notFound().build();

        trip.setId(id);

        tripRepository.save(trip);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public TripDto create(@RequestBody @Valid Trip trip) {
        TripDto tripDto = new TripDto(trip.getId(), trip.getCompany(),
                trip.getTimeIn(),trip.getTimeOut(),trip.getFromCity(),trip.getToCity());
        tripDto = tripService.create(tripDto);
        return tripDto;
    }
}
