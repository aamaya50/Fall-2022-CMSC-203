/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class is used to test the size class
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

public class SizeTestStudent {

	@Test
	public void test() {
		
		Size sizeOne = Size.SMALL;
		Size sizeTwo = Size.MEDIUM;
		Size sizeThree = Size.LARGE;
		
		assertTrue(sizeOne.compareTo(sizeTwo) > 0);
		
		assertTrue(sizeThree.compareTo(sizeTwo) < 0);
		
		assertTrue(sizeThree.compareTo(sizeThree) == 0);
		
		
		
	}

}
