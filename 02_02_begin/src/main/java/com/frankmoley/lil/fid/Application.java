package com.frankmoley.lil.fid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.frankmoley.lil.fid.Config.ApplicationConfig;
import com.frankmoley.lil.fid.service.OutputService;

public class Application {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = applicationContext.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
