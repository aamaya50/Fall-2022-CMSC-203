/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a utility class that works with the HolidayBonusGUI class. This class manipulates a
* two-dimensional ragged array of double. It shows what store sold the most, less, and what the holiday
* bonus for the store is. 
* 
* Due: 11/15/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/



import java.io.*;
import java.io.File;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility 
{
	//constant variables used as bounds for a dummy array
	private final static int MAX_ROW = 10;
	private final static int MAX_COLUMN = 10;
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file to be read
	 * @return the 2D double array
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		//opens file for scanning
		Scanner scan = new Scanner(file);
		
		//dummy array instantiated to max bounds
		String[][] line = new String[MAX_ROW][MAX_COLUMN];
		
		//for loop to make every index in the array equal to null
		for(int row = 0; row < line.length; row++)
		{
			for(int column = 0; column < line[row].length; column++)
			{
				line[row][column] = null;
			}
		}
		
		//while loop to iterate through the file while a element is present
		while(scan.hasNextLine())
		{
			//for loop to assign the elements in the file to the dummy array
			for(int row = 0; row < line.length; row++)
			{
				//if statement to determine if a line is present
				if(scan.hasNextLine())
				{
					//sets the line of the file to a temporary array with values from the file's line
					//and strips the whitelines and spaces in between the values
					String[] temp = scan.nextLine().strip().split(" ");
					
					//sets the values in the dummy array to the values read from the file
					for(int col = 0; col < temp.length; col++)
					{
						line[row][col] = temp[col];
					}
				}
			}
		}	
		
		//variable to determine number of rows in real to be returned
		int rowLen = 0;
		//real array to be returned
		double[][] real;
		
		//for loop to iterate through dummy array
		for(int i = 0; i < line.length; i++)
		{
			//if the value at a row is not null in the dummy array then that row exists
			if(line[i][0] != null)
			{
				//increment the row length variable to number of real rows
				rowLen += 1;
			}
		}
		
		//instantiate the real array to the number of real rows in dummy array
		real = new double[rowLen][];
		
		//variable to determine number of column in the row
		int colLen = 0;
		
		//for loop to iterate through the real array's rows
		for(int row = 0; row < real.length; row++)
		{
			//for loop to iterate through the rows length of the dummy array
			for(int col = 0; col < line[row].length; col++)
			{
				//if the value in the dummy array is not null then a value exists
				if(line[row][col] != null)
				{
					colLen += 1;
				}
				
			}
			
			//makes the real array at a row the number of present columns in the dummy array at that row
			real[row] = new double[colLen];
			
			//resets the length variable
			colLen = 0;
		}
		
		//for loop to iterate through the real array's rows and columns
		for(int row = 0; row < real.length; row++)
		{
	
			for(int column = 0; column < real[row].length; column++)
			{
				//takes the value of the dummy array to the real array at a row and column and turns it into a double
				real[row][column] = Double.parseDouble(line[row][column]);
			}
				
		}
		
		
		//closes the file
		scan.close();
		
		//returns the real array
		return real;
	
		
	}
	
	/**
	 * Writes a an array to a file
	 * @param data to written to file
	 * @param outputFile to be written to
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		//opens file for writing
		PrintWriter f = new PrintWriter(outputFile);
		
		//for loop to iterate through the array's row and column
		for(int row = 0; row < data.length; row++)
		{
			
			for(int column = 0; column < data[row].length; column++)
			{
				//writes the data from the array to the file seperated by a space
				f.print(data[row][column] + " ");
				
			}
			
			//new line after every row
			f.print("\n");
		}
	
		//closes file
		f.close();	
		
	}

	/**
	 * Returns the total of all the elements in the array
	 * @param data the two dimensional array whose values are to be accumulated
	 * @return the total of the array
	 */
	public static double getTotal(double[][] data)
	{
		//accumulator
		double total = 0;
		
		//for loop to iterate through the array
		for(int row = 0; row < data.length; row++)
		{
			for(int column = 0; column < data[row].length; column++)
			{
				total += data[row][column];
			}
		}
		
		return total;
		
	}
	
	/**
	 * Gets the average of the elements in the two dimensional array
	 * @param data two dimensional array to be found the average from
	 * @return the average of the elements in the two dimensional array
	 */
	public static double getAverage (double[][] data)
	{
		//variable to hold number of elements
		int numElements = 0;
		
		//for loop to iterate through the two dimensional array, finding the number of elements
		for(int row = 0; row < data.length; row++)
		{
			numElements += data[row].length;
		}
		
		//uses the getTotal method divided by the number of elements to determine the average
		return getTotal(data)/numElements;
	}
	
	/**
	 * Gets a certain row's total
	 * @param data two dimensional value whose row total is to be found
	 * @param row number to find total
	 * @return the two dimensional row's total
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		//accumulator
		double total = 0;
		
		//for loop to iterate through the two dimensional row's columns
		for(int i = 0; i < data[row].length; i++)
		{
			total += data[row][i];
		}
		
		return total;
		
	}
	
	/**
	 * Gets a column's total in a two dimensional array
	 * @param data two dimensional array whose column total is to be found
	 * @param column whose total is to be determined
	 * @return the total of a two dimensional array's column
	 */
	public static double getColumnTotal(double[][] data, int column)
	{
		//accumulator variable
		double total = 0;
		
		//for loop to iterate through the two dimensional array at a specific column
		for(int i = 0; i < data.length; i ++)
		{
			//if statement to determine if the column exists in the row
			if(column < data[i].length)
			{
				total += data[i][column];
			}	
		}
		
		return total;
		
	}
	
	/**
	 * Gets the highest value in a row in a two dimensional array
	 * @param data two dimensional array whose highest row is to be determined
	 * @param row used to determine highest in it's own row
	 * @return the highest in the row
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		//variable used to compare all other values in the row
		double highest = data[row][0];
		
		//for loop to iterate through the array's row
		for(int i = 0; i < data[row].length; i++)
		{
			//if the value in the next value is greater than the highest variable than the highest variable
			//is set to a new value
			if(data[row][i] > highest)
			{
				highest = data[row][i];
			}
		}
		
		return highest;
		
	}
	
	/**
	 * Gets the index of the highest element in a row
	 * @param data two dimensional array whose index is to be returned
	 * @param row who is used to determine index
	 * @return the index of the highest element in a row
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		
		double highest = data[row][0];
		
		int column = 0;
		
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > highest)
			{
				highest = data[row][i];
				column = i; //returns the index where the highest value is in a row
			}
		}
		
		return column;
	}
	
	/**
	 * Gets the lowest value in a row
	 * @param data two dimensional array whose row is used to determine the lowest value
	 * @param row used to determine lowest value
	 * @return the lowest value in a two dimensional array's row
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		
		//variable used to compare next values in a row
		double lowest = data[row][0];
		
		//for loop that iterates and compares through the two dimensional array's row
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < lowest)
			{
				lowest = data[row][i];
			}
		}
		
		return lowest;
		
	}
	
	/**
	 * Gets the index of the lowest value in a two dimensional array's row
	 * @param data two dimensional array used to determine lowest value
	 * @param row whose index will give the lowest value
	 * @return
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = data[row][0];
		
		int column = 0;
		
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < lowest)
			{
				lowest = data[row][i];
				column = i;
			}
		}
		
		return column;
		
	}
	
	/**
	 * Gets the highest value in column
	 * @param data two dimensional array to be used 
	 * @param col number
	 * @return the highest value in a column from a given two dimensional array
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		//begin at row 0
		int row = 0;
		
		//variable to hold highest value
		double highest;
		
		//determines which row to start by chekcing if the column exists in said row
		while(data[row].length-1 < col)
		{
			row++;
		}
		
		//sets variable to compare other values
		highest = data[row][col];
		
		//for loop to iterate through the two dimensional array
		for(int i = 0; i < data.length; i++ )
		{
			//determines if the column exists in the array's row
			if(data[i].length > col)
			{
				if(data[i][col] > highest)
				{
					highest = data[i][col];
				}
			}
		}
		
		return highest;
		
	}
	
	/**
	 * Gets the index of the highest value in a two dimensional array's row
	 * @param data two dimensional array to be checked
	 * @param col whose index will be the highest in that column
	 * @return the index of the highest value in a two dimensional array's column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		int row = 0;
		
		double highest;
		
		
		while(data[row].length-1 < col)
		{
			row++;
		}
		
		highest = data[row][col];
		
		for(int i = 0; i < data.length; i++ )
		{
			if(data[i].length > col)
			{
				if(data[i][col] > highest)
				{
					highest = data[i][col];
					//returns the row in which the column is the highest
					row = i;
				}
			}
		}
		
		return row;
	}
	
	/**
	 * Gets the lowest value in a column in a two dimensional array
	 * @param data two dimensional array to be cheked
	 * @param col is the column to check
	 * @return the lowest value in a column of a two dimensional array
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		//checks beginning at row 0
		int row = 0;
		
		//variable to hold the lowest value0
		double lowest = 0;
		
		//determines if the starting row has the column, if not moves onto the next row until it has the column
		while(data[row].length-1 < col)
		{
			row++;
		}
	
		lowest = data[row][col];
		
		//for loop to iterate through the two dimensional array
		for(int i = 0; i < data.length; i++)
		{
			//if statement to check if the column exists in that row
			if(data[i].length > col)
			{
				if(data[i][col] < lowest)
				{
					lowest = data[i][col];
				}
			}
			else
			{
				
			}
		}
		
		return lowest;
		
	}
	
	/**
	 * Gets the index of the lowest value of a column in a two dimensional array
	 * @param data two dimensional array to be checked
	 * @param col is the column to check
	 * @return the index of the lowest value in a two dimensional array
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		
		int row = 0;
		
		double lowest = 0;
		
		while(data[row].length-1 < col)
		{
			row++;
		}
		
		lowest = data[row][col];
		
		for(int i = 0; i < data.length; i++)
		{
			if(data[i].length > col)
			{
				if(data[i][col] < lowest)
				{
					lowest = data[i][col];
					
					//row where the column is the lowest
					row = i;
				}
			}
		}
		
		return row;
		
	}
	
	/**
	 * Gets the highest value in an array
	 * @param data two dimensional array to be checked
	 * @return the highest value in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data)
	{
		
		double highest = data[0][0];
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		
		return highest;
		
	}
	
	/**
	 * Gets the lowest value in a two dimensional array
	 * @param data two dimensional array to be checked
	 * @return the lowest value in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		
		return lowest;
	}
	
}
