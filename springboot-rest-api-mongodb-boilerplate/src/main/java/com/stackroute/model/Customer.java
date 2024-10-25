package com.stackroute.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "customer")
public class Customer {

	@Id
	private String id;
	private String name;
	private String phoneNumber;
	private List<Transaction> transactions;

	public Customer() {
		
	}



	public Customer(String id, String name, String phoneNumber, List<Transaction> transactions) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.transactions = transactions;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Transaction> getTransactions() {
        return transactions;
    }

	public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", transaction=" + transactions
				+ "]";
	}

	

}
