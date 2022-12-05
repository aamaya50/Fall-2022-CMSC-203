/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class tests the methods of the type class
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

public class TypeTestStudent {

	@Test
	public void test() {
		
		Type typeOne = Type.ALCOHOL;
		Type typeTwo = Type.COFFEE;
		Type typeThree = Type.SMOOTHIE;
		
		assertFalse(typeOne.equals(typeTwo));
		assertFalse(typeTwo.equals(typeOne));
		
	}

}
