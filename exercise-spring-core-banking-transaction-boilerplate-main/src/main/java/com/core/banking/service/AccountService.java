package com.core.banking.service;

import com.core.banking.model.Account;

public class AccountService {

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public double checkAccountBalance() {
        return account.getBalance();
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    // Define a method to withdraw money from the account
    public void withdraw(double amount) {

        // Check if the account has sufficient balance to withdraw the specified amount (replace "true" with actual code)
       
		if (amount <= 0) {
			System.out.println("Invalid amount. Withdrawal amount must be greater than zero");
			return;
		}

		if (amount > checkAccountBalance()) {
			System.out.println("Insufficient balance. Withdrawal amount exceeds current balance.");
		}

		else {

			account.setBalance(account.getBalance() - amount);
			
			System.out.println("Withdrawal amount is : " + amount);
			
			System.out.println("New balance: " + checkAccountBalance());
		}
    
        
    }

}