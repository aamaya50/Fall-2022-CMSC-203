/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the bevshop class's methods
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

	BevShop bevshop1;
	
	@Before
	public void setUp() throws Exception {
		
		bevshop1 = new BevShop();
		bevshop1.startNewOrder(10, Day.MONDAY, "Toby", 24);
		
	}

	@After
	public void tearDown() throws Exception {
		
		bevshop1 = null;
		
	}

	@Test
	public void testIsValidTime() {
		
		assertTrue(bevshop1.isValidTime(bevshop1.getCurrentOrder().getOrderTime()));
		
	}

	@Test
	public void testGetMaxNumOfFruits() {
		
		assertEquals(5, bevshop1.getMaxNumOfFruits(), 0);
		
	}

	@Test
	public void testGetMinAgeForAlcohol() {

		assertEquals(21, bevshop1.getMinAgeForAlcohol());
		
	}

	@Test
	public void testIsMaxFruit() {
		
		bevshop1.processSmoothieOrder("Smoothie", Size.SMALL, 7, false);
		
		assertTrue(bevshop1.isMaxFruit(7));
		
	}

	@Test
	public void testGetMaxOrderForAlcohol() {
		
		assertEquals(3, bevshop1.getMaxOrderForAlcohol(), 0);
		
	}

	@Test
	public void testIsEligibleForMore() {
		
		bevshop1.processAlcoholOrder("Beer", Size.LARGE);
		bevshop1.processAlcoholOrder("Wine", Size.LARGE);
		bevshop1.processAlcoholOrder("Whiskey", Size.LARGE);
		
		assertFalse(bevshop1.isEligibleForMore());
		
	}

	@Test
	public void testGetNumOfAlcoholDrink() {
		
		bevshop1.processAlcoholOrder("Beer", Size.LARGE);
		bevshop1.processAlcoholOrder("Wine", Size.LARGE);
		bevshop1.processAlcoholOrder("Whiskey", Size.LARGE);
		
		assertEquals(3, bevshop1.getNumOfAlcoholDrink());
		
	}

	@Test
	public void testIsValidAge() {
		
		assertTrue(bevshop1.isValidAge(bevshop1.getCurrentOrder().getCustomer().getAge()));
		
	}

	@Test
	public void testTotalMonthlySale() {
		
		bevshop1.processAlcoholOrder("Beer", Size.LARGE);
		bevshop1.processCoffeeOrder("Moca", Size.MEDIUM, true, false);
		bevshop1.processSmoothieOrder("Mango Smoothie", Size.SMALL, 1, false);
		
		bevshop1.startNewOrder(12, Day.TUESDAY, "Ann", 19);
		
		bevshop1.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		bevshop1.processSmoothieOrder("Smoothie", Size.SMALL, 3, false);
		
		assertEquals(2, bevshop1.totalNumOfMonthlyOrders());
		
		assertEquals(17.5, bevshop1.totalMonthlySale());
		
	}

	@Test
	public void testGetCurrentOrder() {
		
		bevshop1.processAlcoholOrder("Beer", Size.LARGE);
		bevshop1.processCoffeeOrder("Moca", Size.MEDIUM, true, false);
		bevshop1.processSmoothieOrder("Mango Smoothie", Size.SMALL, 1, false);
		
		bevshop1.startNewOrder(12, Day.TUESDAY, "Ann", 19);
		
		bevshop1.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		bevshop1.processSmoothieOrder("Smoothie", Size.SMALL, 3, false);
		
		assertEquals(7.5, bevshop1.getCurrentOrder().calcOrderTotal());
		
	}

	@Test
	public void testGetOrderAtIndex() {
		
		bevshop1.processAlcoholOrder("Beer", Size.LARGE);
		bevshop1.processCoffeeOrder("Moca", Size.MEDIUM, true, false);
		bevshop1.processSmoothieOrder("Mango Smoothie", Size.SMALL, 1, false);
		
		bevshop1.startNewOrder(12, Day.TUESDAY, "Ann", 19);
		
		bevshop1.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
		bevshop1.processSmoothieOrder("Smoothie", Size.SMALL, 3, false);
		
		assertEquals(7.5, bevshop1.getOrderAtIndex(1).calcOrderTotal());
		
	}

}
