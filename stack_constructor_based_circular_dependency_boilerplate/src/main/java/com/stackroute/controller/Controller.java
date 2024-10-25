package com.stackroute.controller;

import com.stackroute.service.OrderService;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public Controller(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/user-details")
    public String getUserDetails() {
        return userService.getUserDetails();
    }

    @GetMapping("/user-orders")
    public String getUserOrders() {
        return userService.getUserOrders();
    }

    @GetMapping("/order-user")
    public String getOrderUser() {
        return orderService.getOrderUser();
    }
}