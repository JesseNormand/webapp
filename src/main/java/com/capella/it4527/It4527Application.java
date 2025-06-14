package com.capella.it4527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class It4527Application {

    // member variable to store the counter value
    private Integer counter = 0;

    @RequestMapping("/hello")
    public String hellowWorld() { 
        return "Hello World"; 
    }

    // counter endpoint
    @RequestMapping("/counter")
    public String incrementCounter() {
        counter++; // Increment 
        return "Current Counter Value: " + counter;
    }

    public static void main(String[] args) {
        SpringApplication.run(It4527Application.class, args);
    }
}