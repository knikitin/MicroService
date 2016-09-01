package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kostya.nikitin on 8/30/2016.
 */
@RestController
public class HelloController {
    final Logger slf4jLog = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String returnHelloWorld(){
        slf4jLog.info("Return Hello World");

        return "Hello World";
    };
}
