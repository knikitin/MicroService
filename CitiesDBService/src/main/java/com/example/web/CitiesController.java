package com.example.web;

import com.example.domain.Cities;
import com.example.domain.CitiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kostya.nikitin on 8/31/2016.
 */
@RestController
@RequestMapping(value="/")
public class CitiesController {
    final Logger slf4jLog = LoggerFactory.getLogger(CitiesController.class);

    @Autowired
    private CitiesRepository citiesRepository;

    @RequestMapping( method= RequestMethod.GET)
    public List<Cities> findAllCities() {
        slf4jLog.info("Returning all cities");
        return citiesRepository.findAll() ;
    };

}
