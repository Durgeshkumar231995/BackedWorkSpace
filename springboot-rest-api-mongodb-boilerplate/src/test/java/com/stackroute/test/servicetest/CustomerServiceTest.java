package com.stackroute.test.servicetest;

import com.stackroute.model.Transaction;
import com.stackroute.model.Customer;
import com.stackroute.repository.CustomerRepository;
import com.stackroute.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);
        assertNotNull(createdCustomer);
        assertEquals("John Doe", createdCustomer.getName());
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("John Doe");
        when(customerRepository.findById(anyString())).thenReturn(Optional.of(customer));

        Optional<Customer> retrievedCustomer = customerService.getCustomerById("1");
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("John Doe", retrievedCustomer.get().getName());
    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setName("John Doe");

        Customer customer2 = new Customer();
        customer2.setId("2");
        customer2.setName("Jane Doe");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        assertEquals(2, customerService.getAllCustomers().size());
    }

    @Test
    public void testUpdateCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setId("1");
        existingCustomer.setName("John Doe");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId("1");
        updatedCustomer.setName("John Doe Updated");

        when(customerRepository.findById(anyString())).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

        Customer result = customerService.updateCustomer("1", updatedCustomer);
        assertNotNull(result);
        assertEquals("John Doe Updated", result.getName());
    }

    @Test
    public void testDeleteCustomer() {
        Customer customer = new Customer();
        customer.setId("1");
        when(customerRepository.findById(anyString())).thenReturn(Optional.of(customer));

        doNothing().when(customerRepository).delete(any(Customer.class));
        customerService.deleteCustomer("1");

        verify(customerRepository, times(1)).delete(customer);
    }

    @Test
    public void testCalculateCreditScore() {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setTransactions(Arrays.asList(
                new Transaction(LocalDateTime.now(), 100.0, "Transaction 1"),
                new Transaction(LocalDateTime.now(), 200.0, "Transaction 2")
        ));

        when(customerRepository.findById(anyString())).thenReturn(Optional.of(customer));

        double creditScore = customerService.calculateCreditScore("1");
        assertEquals(150.0, creditScore); // (100 + 200) / 2
    }
}
