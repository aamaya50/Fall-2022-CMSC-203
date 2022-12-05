/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the customer class
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CustomerTestStudent {

	Customer cust1, cust2;
	
	@Before
	public void setUp() throws Exception {
		
		cust1 = new Customer("Mary", 21);
		cust2 = new Customer("Ann", 19);
		
	}

	@After
	public void tearDown() throws Exception {
		
		cust1 = cust2 = null;
		
	}

	@Test
	public void testCustomerStringInt() {
		
		Customer cust3 = new Customer("Toby", 29);
		
		assertTrue(cust3.getName().equals("Toby"));
		assertEquals(29, cust3.getAge(), 0);
		
	}

	@Test
	public void testCustomerCustomer() {
		
		Customer cust4 = new Customer(cust1);
		
		assertTrue(cust4.getName().equals(cust1.getName()));
		assertTrue(cust4.getAge() == cust1.getAge());
		
	}

	@Test
	public void testGetName() {
		
		assertTrue(cust1.getName().equals("Mary"));
		assertTrue(cust2.getName().equals("Ann"));
		
	}

	@Test
	public void testToString() {
		
		assertEquals("Name: Mary, Age: 21", cust1.toString());
		assertEquals("Name: Ann, Age: 19", cust2.toString());
		
	}

}
