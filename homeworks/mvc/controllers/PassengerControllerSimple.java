package com.bdg.mvc.controllers;

import com.bdg.mvc.dao.PassengerDao;
import com.bdg.mvc.models.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class PassengerControllerSimple implements Controller {

    @Autowired
    private PassengerDao passengerDao;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //BeanNameUrlHandlerMapping
        if (request.getMethod().equals("GET")) {
            List<Passenger> passengers = passengerDao.findAll();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("passengers");
            modelAndView.addObject("PassengersFromServer", passengers);
            return modelAndView;
        }
        return null;
    }
}
