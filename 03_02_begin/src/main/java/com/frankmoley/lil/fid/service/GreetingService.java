package com.frankmoley.lil.fid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * 
 */

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
    }

    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
