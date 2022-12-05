/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the coffee class
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

public class CoffeeTestStudent {

	Coffee coffee1, coffee2;
	
	@Before
	public void setUp() throws Exception {
		
		coffee1 = new Coffee("Moca", Size.SMALL, true, false);
		coffee2 = new Coffee("Latte", Size.LARGE, true, true);
		
	}

	@After
	public void tearDown() throws Exception {
		
		coffee1 = coffee2 = null;
		
	}

	@Test
	public void testCalcPrice() {
		
		assertEquals(2.5, coffee1.calcPrice(), 0);
		assertEquals(5.0, coffee2.calcPrice(), 0);
		
	}

	@Test
	public void testToString() {
		
		assertEquals("Beverage name: Moca, Size: SMALL, extra shot, Price was: 2.5", coffee1.toString());
		assertEquals("Beverage name: Latte, Size: LARGE, extra shot, extra syrup, Price was: 5.0", coffee2.toString());
		
	}

	@Test
	public void testCoffee() {
		
		Coffee coffee3 = new Coffee("Coffee", Size.SMALL, false, false);
		
		assertTrue(coffee3.getBevName().equals("Coffee"));
		assertTrue(coffee3.getSize() == Size.SMALL);
		assertTrue(coffee3.getExtraShot() == false);
		assertTrue(coffee3.getExtraSyrup() == false);
		
	}

	@Test
	public void testEqualsCoffee() {
		
		assertFalse(coffee1.equals(coffee2));
		
	}

	@Test
	public void testGetExtraShot() {
		
		assertTrue(coffee1.getExtraShot() == true);
		
		assertTrue(coffee2.getExtraShot() == true);
		
	}

	@Test
	public void testGetExtraSyrup() {
		
		assertTrue(coffee1.getExtraSyrup() == false);
		
		assertTrue(coffee2.getExtraSyrup() == true);

	}

}
