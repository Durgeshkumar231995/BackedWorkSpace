package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.oops.Employee.EmployeeBuilder;

public class EmployeeServiceTests {

	EmployeeService employeeService;
	Employee employee;
	EmployeeBuilder employeeBuilder;

	@BeforeEach
	public void setUp() {

		employeeService = new EmployeeService();

	}

	@AfterEach
	public void tearDown() {
		employeeService = null;
	}

	@Test
	public void testCreateBasicEmployee() {

		Employee createBasicEmployee = employeeService.createBasicEmployee(1, "Durgesh", "Gupta");
		assertNotNull(createBasicEmployee);
	}
	


	@Test
	public void testCreateEmployeeWithAddress() {

		Employee createBasicEmployee = employeeService.createEmployeeWithAddress(2, "Durgesh", "Gupta", "Mumbai");
		assertNotNull(createBasicEmployee);
	}

	@Test
	public void testCreateEmployeeWithAge() {

		int myAge = 25;
		short age = (short) myAge;
		Employee createBasicEmployee = employeeService.createEmployeeWithAge(3, "Durgesh", "Gupta", age);
		assertNotNull(createBasicEmployee);
	}
	
	@Test
	public void testCreateEmployeeWithInValidEmployeeAge() {
		  employee = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("667788abcd").withOptionalAge((short)17).buildEmployee();
		  assertEquals(0, employee.getAge());
		 
	}
	
	
	
	@Test
	public void testInValidEmpPhoneNumberMorethanTenDigit() {

		Employee emp = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("9867554433445566")
				.withOptionalAge((short) 20).buildEmployee();
		 assertEquals("Invalid", emp.getPhone()); 
		 assertEquals(20, emp.getAge()); 
	}
	
	@Test
	public void testInValidEmpPhoneNumberLessthanTenDigit() {

		Employee emp = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("98675544")
				.withOptionalAge((short) 20).buildEmployee();
		 assertEquals("Invalid", emp.getPhone()); 
		 assertEquals(20, emp.getAge()); 
	}

	@Test
	public void testCreateEmployeeWithPhone() {

		Employee createBasicEmployee = employeeService.createEmployeeWithPhone(3, "Durgesh", "Gupta", "9876542366");
		assertNotNull(createBasicEmployee);
	}

	@Test
	public void testCreateEmployeeWithAgePhoneAndAddress() {

		int myAge = 25;
		short age = (short) myAge;
		Employee createBasicEmployee = employeeService.createEmployeeWithAgePhoneAndAddress(3, "Durgesh", "Gupta", age,
				"9876542366", "Kolkata");
		assertNotNull(createBasicEmployee);
	}

}
