/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the HolidayBonus class.
* 
* Due: 11/15/2022
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

public class HolidayBonusTestStudent {

	private double[][] dataset = {{7,9,1},
								  {1,2},
								  {3,4,2}};
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonus() {
		try 
		{
			double[] bonus = HolidayBonus.calculateHolidayBonus(dataset);
			assertEquals(11000.0, bonus[0], 0);
			assertEquals(2000.0, bonus[1], 0);
			assertEquals(9000.0, bonus[2], 0);
		}
		catch(Exception e)
		{
			fail("This should not have caused an exception");
		}
	}

	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataset), 0);
	}

}
