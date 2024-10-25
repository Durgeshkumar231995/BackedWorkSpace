package com.stackroute.model;

import java.time.LocalDateTime;

public class Transaction {

	private LocalDateTime date;
	private double amount;
	private String description;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(LocalDateTime date, double amount, String description) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", amount=" + amount + ", description=" + description + "]";
	}

}
