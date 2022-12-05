/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the day class
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DayTestStudent {

	@Test
	public void test() {
		
		Day dayOne = Day.MONDAY;
		assertTrue(dayOne.compareTo(Day.TUESDAY) < 0);
		
		Day dayThree = Day.WEDNESDAY;
		assertTrue(dayThree.compareTo(Day.TUESDAY) > 0);
		
		assertTrue(dayThree.compareTo(Day.WEDNESDAY) == 0);
		
	}

}
