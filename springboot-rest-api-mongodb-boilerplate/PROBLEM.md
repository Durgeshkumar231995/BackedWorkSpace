# Assignment: Customer Credit Score Management System
Design and implement a Customer Credit Score Management System for a banking application. The system will manage customer information, track their transaction history, and calculate their credit scores based on predefined rules. The system should expose RESTful APIs to create, update, retrieve, and delete customer information, as well as to retrieve their credit scores. All data will be stored in MongoDB.

## Concept Covered:
Spring Boot 3.3.1, RESTful API design, MongoDB integration
## Instructions:

### 1. Project Setup:

You will receive a starter project with a basic pom.xml file and a Spring Boot application structure.
- Add the required dependencies for mongoDB connector.
- Ensure that you have Java 17 installed on your system.
### 2. Database Configuration:

Create a MongoDB database for the application.
Update the application.properties file with the appropriate database connection details.
### 3. Model Class:

Create an entity class named `Customer` with the following attributes:
- id (auto-generated)
- name (String)
- phoneNumber (string)
- transaction (Transaction)

Create an entity class named `Transaction` with the following attributes:
- date (LocalDateTime)
- amount (double)
- description (string)

### 4. Repository Interface:

Create a repository interface for the "Customer" entity by extending the MongoRepository.
### 5. Service Class:

Implement a service class for "Customer" with the following methods:
- createCustomer: Create a new customer and return the same customer as response
- getCustomerById: Retrieve a customer by its ID.
- getAllCustomers:  Retrieve all customers from the database.
- updateCustomer: Update an existing customer by its ID and return the same as response.
- deleteCustomer: Delete a customer by its ID and return the response as "Customer Deleted".
- calculateCreditScore: Credit score calculation based on transactions and return the score as response.

### 6. Controller:

Create a RESTful controller for the "Customer" entity and return response as ResponseEntity.
- Define the following endpoints and methods:
   - POST /api/customers: Create a new customer.

   - GET /api/customers/{id}: Retrieve customer by ID.
  
   - GET /api/customers: Retrieve all customers.
  
   - PUT /api/customers/{id}: Update customer by ID.
  
   - DELETE /api/customers/{id}: Delete customer by ID.
  
   - GET /api/customers/{id}/creditscore: Retrieve customer's credit score.

Use a tool like Postman or CURL to test your API endpoints.
