## Banking System

### Objective

Simple banking system that allows users to perform transactions like deposit and withdrawal on an account.

1. Implement **withdraw()** method of the class **AccountService**,

   - Method withdraws money from the account
   - Check if the account has sufficient balance to withdraw the specified amount
   - If true Decrease the balance of the account by the specified amount
   - Print an error message if there is insufficient balance

2. Implement **checkAccountBalance()** method of the class **BankService**

   - Method to check the account balance
   - Check if the account is initialized (not null)
   - If true, Return the balance of the account
   - else, Print an error message if the account is not initialized
   - and Return 0.0 as a default balance

3. Implement the **main()** method of the class **App**

    - Create a new application context using the configuration file.
    - Retrieve the bean named "app" from the application context and cast it to the App class
    - Retrieve the bean named "bankService" from the application context and cast it to the BankService class
    - call the setBankService() for the app and pass bankService to the method
    - Execute the makeTransaction method of the app

4. Implement AppConfig.java file
    - Define a bean named "account" of class "com.core.banking.model.Account"
    - Define a bean named "accountService" of class "com.core.banking.service.AccountService"
    - Define a bean named "bankService" of class "com.core.banking.service.BankService"
    - Define a bean named "app" of class "com.core.banking.App

5. Add newest version of spring dependencies in pom.xml file

### Components

1. **Account**:

   - `accountNumber`: Unique identifier for each account.
   - `balance`: Current balance in the account.

2. **Transaction**:

   - `transactionId`: Unique identifier for each transaction.
   - `type`: Type of transaction (e.g., deposit, withdrawal).
   - `amount`: Amount involved in the transaction.
   - `date`: Date and time of the transaction.

3. **AccountService**:

   - Manages account-related operations.
   - `checkAccountBalance()`: Retrieve the current balance of the account.
   - `deposit(double amount)`: Deposit a specified amount into the account.
   - `withdraw(double amount)`: Withdraw a specified amount from the account if sufficient balance is available.

4. **BankService**:

   - Manages banking operations.
   - `checkAccountBalance()`: Retrieve the current balance of the account.
   - `deposit(double amount)`: Deposit a specified amount into the account.
   - `withdraw(double amount)`: Withdraw a specified amount from the account if sufficient balance is available.

5. **App**:
   - Main application class to handle user interactions.
   - `makeTransaction()`: Provides a menu-driven interface for users to choose and perform transactions.
   - `main(String[] args)`: Entry point of the application. Initializes the Spring context and starts the transaction process.

### Flow

1. **Initialization**:

   - The application loads an Application configuration file (`AppConfig.class`) to initialize the Spring context.
   - Beans for `App`, `BankService`, and `Account` are instantiated and dependencies are injected using Spring's dependency injection.

2. **User Interaction**:

   - The `App` class displays a menu for the user to choose the transaction type.
   - The user can select from:
     - Deposit
     - Withdraw
     - Exit

3. **Transaction Execution**:

   - Based on the user's choice, the corresponding method from `BankService` is invoked to perform the transaction.
   - For deposit, the user is prompted to enter the deposit amount, which is then added to the account balance.
   - For withdrawal, the user is prompted to enter the withdrawal amount. If the account has sufficient balance, the specified amount is deducted from the account balance; otherwise, an "Insufficient funds" message is displayed.

4. **Exit**:
   - The user can choose to exit the transaction process, which terminates the application.

### Error Handling

- Invalid input from the user is handled gracefully with appropriate error messages.
- Insufficient balance during withdrawal is detected, and the user is notified accordingly.
- If the account is not initialized (`null`), appropriate error messages are displayed.

### Note

- This is a basic implementation focusing on core banking functionalities.
- The system uses Spring for dependency injection and configuration management.
- The main aim is to demonstrate the interaction between different components in a banking system.
