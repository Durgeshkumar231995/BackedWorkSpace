package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/*
* Enable client annotation to indicate the application as eureka client
 */
@EnableDiscoveryClient
public class RestWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestWebServiceApplication.class, args);
    }

}
