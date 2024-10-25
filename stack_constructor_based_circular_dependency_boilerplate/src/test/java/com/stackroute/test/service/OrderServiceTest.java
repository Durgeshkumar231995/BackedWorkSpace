package com.stackroute.test.service;

import com.stackroute.service.OrderService;
import com.stackroute.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOrders() {
        // Mock the behavior of the UserService
        when(userService.getUserDetails()).thenReturn("John Doe");
        // Test the OrderService
        String orders = orderService.getOrders().toString();
        assertEquals("[Order1, Order2]", orders);
    }

    @Test
    public void testGetOrderUser() {
        // Mock the behavior of the UserService
        when(userService.getUserDetails()).thenReturn("John Doe");
        // Test the OrderService
        String orderUser = orderService.getOrderUser();
        assertEquals("Ordered user: John Doe", orderUser);
    }
}