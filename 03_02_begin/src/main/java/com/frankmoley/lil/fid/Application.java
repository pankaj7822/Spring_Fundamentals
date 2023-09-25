package com.frankmoley.lil.fid;

import com.frankmoley.lil.fid.config.ApplicationConfig;
import com.frankmoley.lil.fid.service.OutputService;
import com.frankmoley.lil.fid.service.OutputService2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);
        OutputService2 outputService2 = context.getBean(OutputService2.class);

        outputService.generateOutput();
        outputService2.generateOutput();

    }
}
