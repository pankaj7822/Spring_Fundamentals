package com.frankmoley.lil.fid.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * Since this is Marked with @Service Spring will scan this Class, create its bean by calling its constructor.
 * If Constructor has parameters It will look for Beans of Matching type for Dependency Injection.
 * 
 * In our case Here is a constructor for OutputService2. 
 * The Classes for objects sent in param also has beans managed by Spring as they are also annotated with @Service
 * 
 * What if the class has multiple constructor?
 * 
 * 
 * Here are the rules Spring follows.
 * 
 * 1. Explicit @Autowired: If you explicitly annotate one of the constructors with @Autowired, Spring will use that constructor.
 * Eg.
 * @Autowired
    public MyBean(DataSource dataSource) {
    // Constructor with explicit @Autowired annotation
    }
 * 
 * 
 * 2. No-Argument Constructor:If there is a no-argument constructor (a constructor with no parameters), Spring will use it by default.
 *  If the class has only one constructor, and it's a no-argument constructor, Spring will use that constructor.
 * 
 * 3. Most Arguments Match: If there are multiple constructors with arguments,
 *  Spring selects the constructor that has the most arguments whose types can be satisfied by the beans available in the Spring container. 
 * If there is a tie in the number of satisfied arguments, Spring will throw an exception because it cannot decide which constructor to use.
 * 
 * what if dependencies in constructor has multiple beans?
 * 
 * Qualifiers: If you use the @Qualifier annotation on constructor parameters to specify which bean should be injected,
 *  Spring will consider these qualifiers during constructor resolution.
 * 
 * eg
 * public MyBean(@Qualifier("dataSourceA") DataSource dataSource) {
    // Constructor with @Qualifier annotation
}
*/
@Service
public class OutputService2 {


    @Value("${app2.name}")
    private String name;

    private GreetingService greetingService;

    private TimeService timeService;

    public OutputService2(GreetingService greetingService,TimeService timeService) {
        this.timeService=timeService;
        this.greetingService = greetingService;
    }

    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}