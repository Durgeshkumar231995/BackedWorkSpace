package com.stackroute.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.model.Customer;
import com.stackroute.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

//	POST /api/customers: Create a new customer.
	@PostMapping("/api/customers")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		Customer createCustomer = customerService.createCustomer(customer);

		return new ResponseEntity<>(createCustomer, HttpStatus.OK);
	}

//	GET /api/customers/{id}: Retrieve customer by ID.
	@GetMapping("/api/customers/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable String id) {
		Optional<Customer> customerById = customerService.getCustomerById(id);

		return new ResponseEntity<>(customerById, HttpStatus.OK);
	}

//	GET /api/customers: Retrieve all customers.
	@GetMapping("/api/customers")
	public ResponseEntity<?> getAllCustomers() {

		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

//	PUT /api/customers/{id}: Update customer by ID.
	@PutMapping("/api/customers/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
		Customer updateCustomer = customerService.updateCustomer(id, customer);
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	}

//	DELETE /api/customers/{id}: Delete customer by ID.
	@DeleteMapping("/api/customers/{id}")
	public ResponseEntity<?> testDeleteCustomer(@PathVariable String id) {
		try {
			Customer deleteCustomer = customerService.deleteCustomer(id);
			return new ResponseEntity<>(deleteCustomer, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

//	GET /api/customers/{id}/creditscore: Retrieve customer's credit score.
	@GetMapping("/api/customers/{id}/creditscore")
	public ResponseEntity<?> testGetCreditScore(@PathVariable String id) {
		double calculateCreditScore = customerService.calculateCreditScore(id);
		return new ResponseEntity<>(calculateCreditScore, HttpStatus.OK);
	}

}
