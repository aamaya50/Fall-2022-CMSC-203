/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the smoothie class
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

public class SmoothieTestStudent {

	Smoothie smoothie1, smoothie2;
	
	@Before
	public void setUp() throws Exception {
		
		smoothie1 = new Smoothie("Milkshake", Size.MEDIUM, 2, true);
		smoothie2 = new Smoothie("Milkshake", Size.SMALL, 4, false);
		
	}

	@After
	public void tearDown() throws Exception {
		
		smoothie1 = smoothie2 = null;
		
	}

	@Test
	public void testCalcPrice() {
		
		assertEquals(5.5, smoothie1.calcPrice(), 0);
		assertEquals(4.0, smoothie2.calcPrice(), 0);
		
	}

	@Test
	public void testToString() {
		
		assertEquals("Beverage name: Milkshake, Size: MEDIUM, Protein was added, 2 fruits were added, Price was: 5.5", smoothie1.toString());
		assertEquals("Beverage name: Milkshake, Size: SMALL, 4 fruits were added, Price was: 4.0", smoothie2.toString());
		
	}

	@Test
	public void testSmoothie() {
		Smoothie smoothie3 = new Smoothie("Smoothie", Size.LARGE, 3, true);
		
		assertTrue(smoothie3.getBevName().equals("Smoothie"));
		assertTrue(smoothie3.getSize() == Size.LARGE);
		assertTrue(smoothie3.getNumOfFruits() == 3);
		assertTrue(smoothie3.getAddProtein() == true);
		
	}

	@Test
	public void testEqualsSmoothie() {
		
		assertFalse(smoothie1.equals(smoothie2));
		
	}

	@Test
	public void testGetAddProtein() {
		
		assertTrue(smoothie1.getAddProtein() == true);
		assertTrue(smoothie2.getAddProtein() == false);
		
	}

	@Test
	public void testGetNumOfFruits() {
		
		assertEquals(2.0, smoothie1.getNumOfFruits(), 0);
		assertEquals(4.0, smoothie2.getNumOfFruits(), 0);
		
	}

}
