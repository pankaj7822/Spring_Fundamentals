package com.frankmoley.lil.fid.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.frankmoley.lil.fid.service.AdressService;
import com.frankmoley.lil.fid.service.GreetingService;
import com.frankmoley.lil.fid.service.OutputService;
import com.frankmoley.lil.fid.service.TimeService;

/*
 * In a Maven or Gradle project,we have a predefined project structure that
 * includes directories for source code, resources, and other assets.
 * The src/main/resources directory is one of these predefined
 * directories. src/main/resources is automatically considered as classpath. 
 * Here we have mentioned application.properties to be present at our classpath and consider it as propertySource.
 * 
 *@Value("${greeting.message}") this will be picked from application.properties if it is redefined in environmentVariable it will be overriden
    Here is how property resolution works
    Here's how the property resolution process works:

Property Source: Spring first checks the property sources defined in your application, 
such as properties files (application.properties, application.yml), system properties, and other property sources configured in your application.

Environment Variables: If a property with the same key is also defined as an environment variable, 
Spring will use the value from the environment variable, effectively overriding the value from the property source.

Default Value: If the property is not found in either the property source or as an environment variable, 
Spring can fall back to using a default value specified in the @Value annotation. For example: @Value("${some.property:default-value}")

@Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")  this is spring expression language we can do very complex operations for configurations with it.
*/
@Configuration
@PropertySource("classpath:application.${spring.profiles.active}.properties")
public class ApplicationConfig {
    /*
     * Here we are using @Autowired annotation over TimeService so it says Spring to
     * inject an instance of type TimeService to tService object.
     * Spring looks for a Bean of Type TimeService(Return type of function should be
     * TimeService methodName has nothing to do with the resolution).
     * 
     * In our Case we have two Beans that returns TimeService so we will have to
     * pass name as param
     * with @Bean annotation otherwise we will get """expected single matching bean
     * but
     * found 2: timeService,timeService2""" as error. Now when we are
     * using @Autowired we will
     * also have to use @Qualifier and provide the name that will qualify for Bean
     * initialization.
     * 
     * 
     */
    @Value("${greeting.message}")
    private String greeting;

    @Value("${person.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private Boolean isActive;

    @Autowired
    @Qualifier("24")
    private TimeService tService;

    @Autowired
    private GreetingService gService;

    @Autowired
    private AdressService adService1;

    
    @Bean(name = "24")
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean(name = "12")
    TimeService timeService2() {
        return new TimeService(false);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(gService, tService,adService1,name,isActive);
    }
    
    @Bean
    @Profile("!dev")
    public AdressService adressService1() {
        return new AdressService("India");
    }

    @Bean
    @Profile("dev")
    public AdressService adressService2() {
        return new AdressService("Nepal");
    }
}
