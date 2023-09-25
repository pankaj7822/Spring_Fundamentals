package com.frankmoley.lil.fid.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * Here we have mentioned the base Package to look for Componets
 *  @ComponentScan(basePackages = "com.frankmoley.lil.fid")
*/
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.frankmoley.lil.fid")
public class ApplicationConfig {

}
