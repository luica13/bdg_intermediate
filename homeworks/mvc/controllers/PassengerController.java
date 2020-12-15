package com.bdg.mvc.controllers;

import com.bdg.mvc.dao.PassengerDao;
import com.bdg.mvc.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class PassengerController {

    @Autowired
    private PassengerDao passengerDao;

    //RequestMappingHandlerMapping
    @RequestMapping(path = "/passengers", method = RequestMethod.GET)
    public ModelAndView getAllPassengers(@RequestParam(value = "name", required = false) String name) {
        List<Passenger> passengers = null;
        if (name != null) {
            passengers = passengerDao.findAllByFirstName(name);
        } else {
            passengers = passengerDao.findAll();
        }
        ModelAndView modelAndView = new ModelAndView("passengers");
        modelAndView.addObject("PassengersFromServer", passengers);
        return modelAndView;
    }

    @RequestMapping(path = "/passengers/{passenger-id}", method = RequestMethod.GET)
    public ModelAndView getPassengerById(@PathVariable("passenger-id") Long id) {
        Optional<Passenger> passengersCandidate = passengerDao.find(id);
        ModelAndView modelAndView = new ModelAndView("passengers");
        passengersCandidate.ifPresent(passenger -> modelAndView
                .addObject("PassengersFromServer", Collections.singletonList(passenger)));
        return modelAndView;
    }
}
