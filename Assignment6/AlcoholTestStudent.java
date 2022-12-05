/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the alcohol class's methods
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


public class AlcoholTestStudent {
	
	Alcohol alcohol1, alcohol2, alcohol3;
	
	@Before
	public void setUp() throws Exception {
		
		alcohol1 = new Alcohol("Whiskey", Size.MEDIUM, false);
		alcohol2 = new Alcohol("Beer", Size.LARGE, true);
		alcohol3 = new Alcohol("Ale", Size.SMALL, false);
			
	}

	@After
	public void tearDown() throws Exception {
		
		alcohol1 = alcohol2 = alcohol3 = null;
	}

	@Test
	public void testCalcPrice() {
		
		assertEquals(3.0, alcohol1.calcPrice(), 0);
		assertEquals(4.6, alcohol2.calcPrice(), 0);
		assertEquals(2.0, alcohol3.calcPrice(), 0);
		
	}

	@Test
	public void testToString() {
		
		assertEquals("Beverage name: Beer, Size: LARGE, is offered during the weekend, Price was: 4.6", alcohol2.toString());
		
	}

	@Test
	public void testAlcohol() {
			
		Alcohol alcohol4 = new Alcohol("Beer", Size.SMALL, false);
		
		assertTrue(alcohol4.getBevName().equals("Beer"));
		assertTrue(alcohol4.getSize() == Size.SMALL);
		assertTrue(alcohol4.isWeekend() == false);
		
	}
}