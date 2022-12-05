/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the order class
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

public class OrderTestStudent {

	Order order1, order2;
	
	@Before
	public void setUp() throws Exception {
		
		order1 = new Order(10, Day.TUESDAY, new Customer("Ann", 19));
		order2 = new Order(11, Day.WEDNESDAY, new Customer("Toby", 29));
		
	}

	@After
	public void tearDown() throws Exception {
		
		order1 = order2 = null;
		
	}

	@Test
	public void testOrder() {
		
		assertEquals(10, order1.getOrderTime(), 0);
		assertTrue(order1.getOrderDay() == Day.TUESDAY);
		assertTrue(order1.getCustomer().getName().equals("Ann"));
		assertEquals(19, order1.getCustomer().getAge());
		
		assertEquals(11, order2.getOrderTime(), 0);
		assertTrue(order2.getOrderDay() == Day.WEDNESDAY);
		assertTrue(order2.getCustomer().getName().equals("Toby"));
		assertEquals(29, order2.getCustomer().getAge(), 0);
		
	}

	@Test
	public void testAddNewBeverage() {
		
		assertTrue(order1.getTotalItems() == 0);
		order1.addNewBeverage("Beer", Size.LARGE);
		assertTrue(order1.getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(order1.getTotalItems() == 1);
		order1.addNewBeverage("Smoothie", Size.MEDIUM, 3, true);
		assertTrue(order1.getBeverage(1).getType().equals(Type.SMOOTHIE));
		assertTrue(order1.getTotalItems() == 2);
		
		
		assertTrue(order2.getTotalItems() == 0);
		order2.addNewBeverage("Moca", Size.SMALL, false, true);
		assertTrue(order2.getBeverage(0).getType().equals(Type.COFFEE));
		assertTrue(order2.getTotalItems() == 1);
		order2.addNewBeverage("Mango Smoothie", Size.MEDIUM, 1, false);
		assertTrue(order2.getBeverage(1).getType().equals(Type.SMOOTHIE));
		assertTrue(order2.getTotalItems() == 2);
		
	}

	@Test
	public void testGetOrderTime() {
		
		assertEquals(10, order1.getOrderTime(), 0);
		assertEquals(11, order2.getOrderTime(), 0);
		
	}

	@Test
	public void testGetOrderDay() {
		
		assertTrue(order1.getOrderDay() == Day.TUESDAY);
		assertTrue(order2.getOrderDay() == Day.WEDNESDAY);
		
	}

	@Test
	public void testGetCustomer() {
	
		assertTrue(order1.getCustomer().getName().equals("Ann"));
		assertEquals(19, order1.getCustomer().getAge());
		
	}

	@Test
	public void testGetDay() {
		
		assertTrue(order1.getOrderDay() == Day.TUESDAY);
		assertTrue(order2.getOrderDay() == Day.WEDNESDAY);
		
	}

	@Test
	public void testGetBeverage() {
		
		order1.addNewBeverage("Latte", Size.MEDIUM, true, true);
		assertTrue(order1.getBeverage(0).getType().equals(Type.COFFEE));
		
	}

	@Test
	public void testCalcOrderTotal() {
		
		order1.addNewBeverage("Beer", Size.LARGE);
		order1.addNewBeverage("Smoothie", Size.MEDIUM, 3, true);
		assertEquals(10.0, order1.calcOrderTotal(), 0);
		
		order2.addNewBeverage("Moca", Size.SMALL, false, true);
		order2.addNewBeverage("Smoothie", Size.SMALL, 4, false);
		assertEquals(6.5, order2.calcOrderTotal(), 0);
		
	}

	@Test
	public void testFindNumOfBeveType() {
		
		order1.addNewBeverage("Beer", Size.LARGE);
		order1.addNewBeverage("Smoothie", Size.MEDIUM, 3, true);
		order1.addNewBeverage("Beer", Size.LARGE);
		order1.addNewBeverage("Moca", Size.SMALL, false, true);
		
		assertEquals(2, order1.findNumOfBeveType(Type.ALCOHOL));

		order2.addNewBeverage("Moca", Size.SMALL, false, true);
		order2.addNewBeverage("Mango Smoothie", Size.MEDIUM, 1, false);
		order2.addNewBeverage("Moca", Size.SMALL, true, true);
		order2.addNewBeverage("Smoothie", Size.SMALL, 4, false);
		
		assertEquals(2, order2.findNumOfBeveType(Type.COFFEE));
		
	}

}
