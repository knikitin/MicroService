package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kostya.nikitin on 8/30/2016.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String returnHelloWorld(){
        return "Hello World";
    };
}
