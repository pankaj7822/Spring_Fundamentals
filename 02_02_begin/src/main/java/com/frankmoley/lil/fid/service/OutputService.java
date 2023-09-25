package com.frankmoley.lil.fid.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;
    private final AdressService adressService;

    private final String name;
    private final Boolean isActive;


    public OutputService(GreetingService greetingService, TimeService timeService,AdressService adressService,String name,Boolean isActive){
        this.greetingService = greetingService;
        this.timeService = timeService;
        this.adressService = adressService;
        this.name = name;
        this.isActive = isActive;
    }

    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " +adressService.getAddress()+" "+isActive+" "+greetingService.getGreeting(name);
        System.out.println(output);
    }

}
