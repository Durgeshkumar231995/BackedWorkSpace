package com.core.banking;


import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.banking.config.AppConfig;
import com.core.banking.service.BankService;

public class App {
    private BankService bankService;

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public void makeTransaction() {
        Scanner scanner = new Scanner(System.in);
        boolean continueTransaction = true;

        while (continueTransaction) {
            System.out.println("Choose transaction type:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice");
                scanner.next(); // Clear the invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankService.deposit(depositAmount);
                    System.out.println("Deposit of $" + depositAmount + " successful");
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    boolean isWithdrawn = bankService.withdraw(withdrawAmount);
                    if (isWithdrawn) {
                        System.out.println("Withdrawal of $" + withdrawAmount + " successful");
                    } else {
                        System.out.println("Insufficient funds");
                    }
                    break;
                case 3:
                    System.out.println("Exiting transaction...");
                    continueTransaction = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    // main method
    public static void main(String[] args) {
        // Create a new application context using the AnnotationConfigApplicationContext object.
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean named "app" from the application context and cast it to the App class

    	App app = (App) context.getBean("app");
        // Retrieve the bean named "bankService" from the application context and cast it to the BankService class

    	 BankService bankService = (BankService) context.getBean("bankService");
        // call the setBankService() for the app and pass bankService to the method
    	 app.setBankService(bankService);
        // Execute the makeTransaction method of the app
    	 app.makeTransaction();



    }

}