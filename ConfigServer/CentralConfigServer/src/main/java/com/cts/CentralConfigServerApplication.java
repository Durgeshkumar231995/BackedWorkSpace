package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableConfigServer
public class CentralConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralConfigServerApplication.class, args);
		
		
	}

}
