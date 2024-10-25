package com.stackroute.swaggerautoconfbean;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.stackroute.swaggerautoconfbean")
public class SwaggerAutoConfBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerAutoConfBeanApplication.class, args);
	}

}
