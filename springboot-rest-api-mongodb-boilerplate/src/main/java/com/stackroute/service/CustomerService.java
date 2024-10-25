package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stackroute.model.Customer;
import com.stackroute.model.Transaction;
import com.stackroute.repository.CustomerRepository;


@Service
public class CustomerService {
	
	CustomerRepository customerRepository;
	
//	createCustomer: Create a new customer and return the same customer as response
	public Customer createCustomer(Customer customer) {
		
		return customerRepository.save(customer);

		
	}
//			getCustomerById: Retrieve a customer by its ID.
	public Optional<Customer> getCustomerById(String id) {
		// TODO Auto-generated method stub
		Optional<Customer> existCustomer = customerRepository.findById(id);
		if(existCustomer.isPresent()) {
			return existCustomer;
		}
		return null;

	}
//			getAllCustomers:  Retrieve all customers from the database.
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
//			updateCustomer: Update an existing customer by its ID and return the same as response.
	public Customer updateCustomer(String id,Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> existCustomer = customerRepository.findById(id);
		if(existCustomer.isPresent()) {
			customer.setId(id);
			return customerRepository.save(customer);
		}
		
		
		return null;

	}
//			deleteCustomer: Delete a customer by its ID and return the response as "Customer Deleted".
	public Customer deleteCustomer(String id) {
		Optional<Customer> existCustomer = customerRepository.findById(id);
		if(existCustomer.isPresent()) {
			 customerRepository.delete(existCustomer.get());
		}
		return existCustomer.get();
	}
	
	
//	calculateCreditScore: Credit score calculation based on transactions and return the score as response.
	public double calculateCreditScore(String Id) {
		Optional<Customer> existingCustomer = customerRepository.findById(Id);
		double totalAmount = 0.0;
		List<Transaction> transaction = null;
		if (existingCustomer.isPresent()) {
			Customer customer = existingCustomer.get();
			transaction = customer.getTransactions();

			if (transaction == null || transaction.isEmpty()) {
				return 0.0;
			}
			totalAmount = transaction.stream().mapToDouble(t -> t.getAmount()).sum();

		}
		return totalAmount / transaction.size();
	}

}
