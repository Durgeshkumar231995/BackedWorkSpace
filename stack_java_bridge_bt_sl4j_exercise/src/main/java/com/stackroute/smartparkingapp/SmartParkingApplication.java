package com.stackroute.smartparkingapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Annotate this class with the @SpringBootApplication annotation
 **/

@SpringBootApplication
public class SmartParkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartParkingApplication.class, args);
    }

    /**
     * This method is used to register modelMapper
     * with the application.
     *
     * @return ModelMapper
     **/
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
