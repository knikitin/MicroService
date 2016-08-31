package com.example.web;

import com.example.dto.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by kostya.nikitin on 8/31/2016.
 */
@Controller
public class CitiesPageController {
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DiscoveryClient discoveryClient;

    public URI getServiceUri(String serviceId) {
        List<ServiceInstance> list = discoveryClient.getInstances(serviceId);
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri();
        }
        return null;
    }

    @RequestMapping("/")
    public String cities( Model model) {
        URI uri = getServiceUri("a-citiesfromdb-client");
        List<Cities> resultList = restTemplate.getForObject(uri.toString()+"cities", List.class);

        model.addAttribute("cities", resultList);

        return "cities";
    }

}
