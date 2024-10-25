package com.stackroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class UserService {
    private String userName="John Doe";
    /**
     * declare a orderService variable as private final
     */
    
    private final OrderService orderService;

    

    /**
     * Autowire the OrderService bean using constructor-based injection
     */

   
 
    @Autowired
    public UserService(OrderService orderService) {
        this.orderService = orderService;
    }


    /**
     return user details
     */
    public String getUserDetails() {
        // Simulate fetching user details
    	
        return this.userName;
    }

    /**
     * return the user's order details.
     */
    public String getUserOrders() {
    	List<String> orders = orderService.getOrders();
    	
    	 String userOrder = "[" +String.join(", ", orders)+ "]";
    	 
		return "User orders: "+userOrder;
        // return String with user details as User orders: orderService.getOrders()
    }
}
