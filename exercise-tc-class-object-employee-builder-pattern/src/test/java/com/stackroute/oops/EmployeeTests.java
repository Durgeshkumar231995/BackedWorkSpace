package com.stackroute.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.oops.Employee.EmployeeBuilder;

public class EmployeeTests {
	
	EmployeeService employeeService;
	Employee employee;
	EmployeeBuilder employeeBuilder;

	@BeforeEach
	public void setUp() {
		employeeBuilder=new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalAddress("Mumbai").withOptionalAge((short)25).withOptionalPhone("9867456655");

	}

	@AfterEach
	public void tearDown() {
		employeeService = null;
	}
	
	@Test
	public void createEmpObject() {
		employee = new Employee(employeeBuilder);
		assertNotNull(employee);
	}
	
	@Test
	public void testValidEmpPhoneAndValidAge() {

		employee = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("9867554433")
				.withOptionalAge((short) 20).buildEmployee();
		 assertEquals("9867554433", employee.getPhone()); 
		 assertEquals(20, employee.getAge()); 
	}
	
	@Test
	public void testDisplayEmp() {

		employee = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("9867554433")
				.withOptionalAge((short) 20).buildEmployee();
		assertEquals("Durgesh", employee.getFirstName());
		assertEquals("9867554433", employee.getPhone());
		assertEquals(20, employee.getAge());

	}
	
	@Test
	public void testPhoneNumberNull() {

		employee = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone(null)
				.withOptionalAge((short) 20).buildEmployee();

		assertEquals(null, employee.getPhone());

	}
	
	@Test
	public void testCreateEmployeeWithValidEmployeeAge() {

		
		Employee emp = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("667788abcd")
				.withOptionalAge((short) 25).buildEmployee();

		assertNotNull(emp);
		assertEquals("Durgesh", emp.getFirstName());
		assertEquals("Gupta", emp.getLastName());
	}
	
	@Test
	public void testCreateEmployeeWithInvalidEmployeePhone() {

		Employee emp = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("667788abcd")
				.withOptionalAge((short) 25).buildEmployee();
		 assertEquals("Invalid", emp.getPhone()); 
	}
	
	@Test
	public void testValidEmployeePhoneAndInvalidAge() {

		Employee emp = new Employee.EmployeeBuilder(1, "Durgesh", "Gupta").withOptionalPhone("6677883322")
				.withOptionalAge((short) 14).buildEmployee();
		 assertEquals("6677883322", emp.getPhone()); 
		 assertEquals(0, emp.getAge()); 
	}

}
