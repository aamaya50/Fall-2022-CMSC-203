/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class works with the HolidayBonusGUI and the TwoDimRaggedArray utility class. This class
* determines the bonus amount for a store, and adds all bonuses for a district together.
* 
* Due: 11/15/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


public class HolidayBonus
{
	//constants that determine bonus amount
	private final static int HIGHESTSALESBONUS = 5000;
	private final static int LOWESTSALESBONUS = 1000;
	private final static int REGBONUS = 2000;
	
	/**
	 * Calculate's the holiday bonus for each store
	 * @param data two dimensional array that holds the data of each store
	 * @return an array filled with the bonus amount of store
	 */
	public static double[] calculateHolidayBonus(double[][] data)
	{
		///array to be returned created with length of the data's length
		double[] bonus = new double[data.length];
		
		//temp variable to hold a bonus amount
		double temp = 0;
		
		//for loop to iterate through the two dimensional array
		for(int row = 0; row < data.length; row++)
		{
			//for loop to iterate through the column of the array
			for(int col = 0; col < data[row].length; col++)
			{
				//series of if statements to determine what type of bonus the store will receive in that column
				if(data[row][col] > 0)
				{
					if(TwoDimRaggedArrayUtility.getHighestInColumn(data, col) == data[row][col])
					{
						temp += HIGHESTSALESBONUS;
					}
					else if(TwoDimRaggedArrayUtility.getLowestInColumn(data, col) == data[row][col])
					{
						temp += LOWESTSALESBONUS;
					}
					else
					{
						temp += REGBONUS;
					}
					//adds the bonus to the array
					bonus[row] = temp;
				}
			}
			//resets the temp variable
			temp = 0;
		}
		return bonus;
		
	}
	
	/**
	 * Calculates the total amount of holiday bonuses across each store
	 * @param data two dimensional array whose total bonus is to be determined
	 * @return the total amount of holiday bonuses for a district
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		//accumulator to hold the total
		double total = 0;

		
		//uses the calculateHolidayBonus to retrieve the bonus array that holds all the bonuses
		double[] bonus = calculateHolidayBonus(data);
		
		//for loop to iterate through the array getting the holiday bonus for each store and accumulating it
		for(int i = 0; i < bonus.length; i++)
		{
			total += bonus[i];
		}
		return total;
		
	}
	
	
}

