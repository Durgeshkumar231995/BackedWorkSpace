package com.core.banking.service;

import com.core.banking.model.Account;

public class BankService {

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    //Method to check the account balance
    public double checkAccountBalance() {
        // Check if the account is initialized (not null)
        if (account != null) {
            // Return the balance of the account
        	return account.getBalance();
        } else {
            // Print an error message if the account is not initialized
        	  System.out.println("Account is not initialized.");
        	return 0.0;
            // Return 0.0 as a default balance
        }
    }
//add code to deposit
    public void deposit(double amount) {
    	
    	if (account != null) {
            if (amount > 0) {
                account.setBalance(account.getBalance() + amount); 
                System.out.println("Deposited: " + amount);
            } else {
                System.out.println("Deposit amount must be greater than zero");
            }
        } else {
            System.out.println("Account is not initialized.");
        }
    }

    

// add code to withdraw
    public boolean withdraw(double amount) {

    	 if (account == null) {
             System.out.println("Your Account is not initialized.");
             return false;
         }

         if (amount <= 0) {
             System.out.println("Withdrawal amount must be greater than zero");
             return false;
         }

         if (amount > account.getBalance()) {
             System.out.println("Insufficient balance");
             return false;
         }

         account.setBalance(account.getBalance() - amount);
         System.out.println("Withdrawal: " + amount);
         return true;

    }
}