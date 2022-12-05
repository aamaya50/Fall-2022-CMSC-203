/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates a coffee beverage to add to an order
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


public class Coffee extends Beverage{
	
	private boolean extraShot;	//boolean variable to hold whether user wants an extra shot
	
	private boolean extraSyrup;	//boolean variable to hold whether user wants extra syrup
	
	private final double EXTRA= 0.5;	//if extra syrup or an extra shot is added then this amound is added to the price
	
	/**
	 * Constructor that creates a coffee beverage object using the super constructor
	 * @param bevName name of the beverage
	 * @param size of the beverage
	 * @param extraShot whether an extra shot is added
	 * @param extraSyrup whether extra syrup is added
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		
		this.extraShot = extraShot;
		
		this.extraSyrup = extraSyrup;
	
		
	}
	
	/**
	 * Calculates the price of the coffee based on the price, size, and whether an extra shot or syrup is added
	 */
	public double calcPrice()
	{
		//uses the super method to get starting price
		double price = super.addSizePrice();
		
		if(extraShot == true)
		{
			price += EXTRA;
		}
		
		if(extraSyrup == true)
		{
			price += EXTRA;
		}
		
		return price;
		
	}
	
	/**
	 * toString method to display information about the coffee
	 */
	public String toString()
	{
		//calls on super toString method to get the beverage name and size
		String str = super.toString();
		
		if(extraShot == true)
		{
			str = str + "extra shot, ";
		}
		
		if(extraSyrup == true)
		{
			str = str + "extra syrup, ";
		}
		
		str = str + "Price was: " + calcPrice();
		
		return str;
		
	}
	
	/**
	 * Compares this coffee beverage with another coffee beverage to determine if they are the same
	 * @param anotherBev other coffee to be compared
	 * @return whether the two coffees were the same
	 */
	public boolean equals(Coffee anotherBev)
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
	
		if(!(this.extraShot != anotherBev.extraShot))
		{
			status = false;
		}
		
		if(!(this.extraSyrup != anotherBev.extraSyrup))
		{
			status = false;
		}
		
		return status;
		
	}
	
	/**
	 * Gets the extra shot boolean variable
	 * @return the extraShot boolean variable
	 */
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	/**
	 * Gets the extra syrup variable
	 * @return the extraSyrup boolean variable
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	

}
