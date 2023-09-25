package com.frankmoley.lil.fid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * 
 * Spring's component scanning mechanism automatically creates beans for classes annotated with
 *  @Component, @Service, @Repository, and @Controller. When you use one of these annotations on a class, you are essentially telling Spring to consider that class as a candidate for bean instantiation and management.

Here's how it works:

Component Scanning: Spring performs component scanning during application startup. 
It scans the specified packages (usually the package where your main application class is located and its subpackages)
 for classes annotated with these stereotypes.

Bean Registration: When Spring identifies a class with one of these annotations,
 it registers that class as a bean in the application context. 
 This means Spring creates an instance of the class and manages its lifecycle.

Dependency Injection: Spring can inject these beans into other beans or components that depend on them.
 You can use @Autowired, constructor injection, or other dependency injection techniques to specify dependencies between beans.

How Spring creates Bean for classes annotated with @Component, @Service, @Repository, and @Controller?

Spring creates beans for classes annotated with @Component, @Service, @Repository, and @Controller by calling the class's constructor. 
Here's how it works:

Constructor-Based Instantiation: When Spring encounters a class annotated with one of these stereotypes during component scanning, 
it creates an instance of that class by invoking its constructor. Spring uses reflection to find and invoke the constructor.

Dependency Injection: If the constructor of the class has parameters, 
Spring resolves the dependencies for those parameters using its dependency injection mechanism. 
It looks for beans of the required types and injects them into the constructor.

Bean Registration: After successfully creating the instance and injecting any required dependencies, 
Spring registers the resulting object as a bean in its application context. 
The bean is given a unique identifier (usually the class name with the first letter in lowercase) that can be used to retrieve it from the application context.

Lifecycle Management: Spring also manages the lifecycle of these beans, which includes initializing them (if they implement InitializingBean or have @PostConstruct methods)
and potentially destroying them (if they implement DisposableBean or have @PreDestroy methods).

Please not in Java we don't have to return in fact we can't return anything from constructor The object that the constructor is initializing is implicitly created 
and returned to the caller when the constructor completes its execution.


Here in this Service we have autowired the Dependencies and there is an empty constructor which will be called during bean Creation.
 */

@Service
public class OutputService {


    @Value("${app.name}")
    private String name;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    public OutputService() {
        
    }

    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}
