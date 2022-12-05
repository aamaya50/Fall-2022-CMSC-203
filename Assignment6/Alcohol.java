/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates an alcohol beverage to add to an order
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


public class Alcohol extends Beverage {
	
	private boolean isWeekend;	//boolean variable used to hold whether it is the weekend or not
	
	private final double EXTRACOST = 0.60;	//extra added if it is the weekend
	
	/**
	 * Constructor that calls super constructor to create a beverage object
	 * @param bevName name of beverage
	 * @param size of beverage
	 * @param isWeekend if it is the weekend or not
	 */
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		
		this.isWeekend = isWeekend;
		
	}
	
	/**
	 * Calculates the price based on whether it is the weekend, and the size of the drink
	 */
	public double calcPrice()
	{
		//uses super class's base price as a starting point for the price
		double price = super.addSizePrice();
		
		//adds extra cost if it is the weekend
		if(isWeekend == true)
		{
			price = price + EXTRACOST; 
		}
		
		return price;
	}

	
	/**
	 * toString method that returns the name, size, whether or not beverage is offered during the weekend and the price
	 */
	public String toString()
	{
		//calls on super toString method to get beverage name and size
		String str = super.toString();
		
		if(isWeekend = true)
		{
			str = str + "is offered during the weekend, ";
		}
		else
		{
			str = str + "is offered during the weekend, ";
		}
		
		str = str + "Price was: " + calcPrice();
		
		return str;
		
	}
	
	/**
	 * Compares two alcohol beverages to see if they are the same
	 * @param anotherBev other alcohol beverage to be compared
	 * @return true or false depending on whether they are the same
	 */
	public boolean equals(Alcohol anotherBev)
	{
		boolean status = true;
		//calls on super class to get the name, type, and size
		if(!(super.beverageName.equals(anotherBev.beverageName)))
		{
			status = false;
		}
		
		if(!(super.type.equals(anotherBev.type)))
		{
			status = false;
		}
		
		if(!(super.size.equals(anotherBev.size)))
		{
			status = false;
		}	
	
		if(this.isWeekend != anotherBev.isWeekend)
		{
			status = false;
		}
		
		
		return status;
	}
	
	/**
	 * Returns the isWeekend variable, it is determined whether it is the weekend in the "order" class
	 * @return the isWekeend boolean variable
	 */
	public boolean isWeekend()
	{
		return isWeekend;
	}
	

}
