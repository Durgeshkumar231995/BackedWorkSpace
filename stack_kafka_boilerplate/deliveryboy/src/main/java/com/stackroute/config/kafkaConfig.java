package com.stackroute.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Add configuration annotation
 */
@Configuration
public class kafkaConfig {
   

    /*
    Build a new topic LOCATION_TOPIC_NAME
     */
    @Bean
    public NewTopic topic(){
    	
    	return new  NewTopic(AppConstants.LOCATION_TOPIC_NAME,1,(short) 1);
    }
}
