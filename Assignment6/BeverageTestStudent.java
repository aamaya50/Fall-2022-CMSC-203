/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the beverage class
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

public class BeverageTestStudent {

	Beverage coffee, alcohol, smoothie;
	
	@Before
	public void setUp() throws Exception {
		
		coffee = new Coffee("Moca", Size.LARGE, false, false);
		alcohol = new Alcohol("Beer", Size.LARGE, false);
		smoothie = new Smoothie("Smoothie", Size.LARGE, 2, false);
		
	}

	@After
	public void tearDown() throws Exception {
		
		coffee = alcohol = smoothie = null;
		
	}

	@Test
	public void testBeverage() {
		
		assertTrue(coffee.getBevName().equals("Moca"));
		assertEquals(2.0, coffee.getBasePrice(), 0);
		assertTrue(coffee.getType() == Type.COFFEE);
		assertTrue(coffee.getSize() == Size.LARGE);
		
	}

	@Test
	public void testCalcPrice() {
		
		assertEquals(4.0, coffee.calcPrice(), 0);
		assertEquals(4.0, alcohol.calcPrice(), 0);
		assertEquals(5.0, smoothie.calcPrice(), 0);
		
	}

	@Test
	public void testToString() {
		
		assertEquals("Beverage name: Moca, Size: LARGE, Price was: 4.0", coffee.toString());
		assertEquals("Beverage name: Smoothie, Size: LARGE, 2 fruits were added, Price was: 5.0", smoothie.toString());
		assertEquals("Beverage name: Beer, Size: LARGE, is offered during the weekend, Price was: 4.6", alcohol.toString());
		
	}

	@Test
	public void testEqualsBeverage() {
		
		assertFalse(coffee.equals(alcohol));
		assertFalse(alcohol.equals(smoothie));
		assertFalse(smoothie.equals(coffee));
		
	}

	@Test
	public void testAddSizePrice() {
		
		assertEquals(4.0, smoothie.addSizePrice(), 0);
		assertEquals(4.0, alcohol.addSizePrice(), 0);
		assertEquals(4.0, coffee.addSizePrice(), 0);
		
	}

	@Test
	public void testGetBasePrice() {
		
		assertEquals(2.0, coffee.getBasePrice(), 0);
		assertEquals(2.0, alcohol.getBasePrice(), 0);
		assertEquals(2.0, smoothie.getBasePrice(), 0);
		
	}

	@Test
	public void testGetType() {
		
		assertTrue(coffee.getType() == Type.COFFEE);
		assertTrue(alcohol.getType() == Type.ALCOHOL);
		assertTrue(smoothie.getType() == Type.SMOOTHIE);
		
	}

	@Test
	public void testGetBevName() {
		
		assertTrue(coffee.getBevName().equals("Moca"));
		assertTrue(alcohol.getBevName().equals("Beer"));
		assertTrue(smoothie.getBevName().equals("Smoothie"));
		
	}

	@Test
	public void testGetSize() {
		
		assertTrue(coffee.getSize() == Size.LARGE);
		assertTrue(alcohol.getSize() == Size.LARGE);
		assertTrue(smoothie.getSize() == Size.LARGE);
		
	}

}
