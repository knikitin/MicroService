package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by kostya.nikitin on 8/30/2016.
 */
@RestController
public class AddToHelloController {

    private RestTemplate restTemplate = new RestTemplate();

    private Logger slf4jLog = LoggerFactory.getLogger(AddToHelloController.class);

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
    public String returnHelloWorld(){
        slf4jLog.info("Get string from other service");
        URI uri = getServiceUri("a-helloworld-client");
        String resultStr = restTemplate.getForObject(uri.toString(), String.class);

        slf4jLog.info("Return string with additive");
        return "Add some " + resultStr;
    }
}
