package com.example.service;

import com.example.dto.Cities;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by kostya.nikitin on 9/6/2016.
 */
public interface CitiesUIService {

    List<Cities> getCities();

    RestTemplate getRestTemplate();

}
