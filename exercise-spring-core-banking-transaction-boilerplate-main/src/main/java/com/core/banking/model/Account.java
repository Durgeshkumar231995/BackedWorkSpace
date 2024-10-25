package com.core.banking.model;


public class Account {

    private String accountNumber;
    private double balance;
    
    public Account() {
        this.balance = 0.0; // Set initial balance to 0
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}

