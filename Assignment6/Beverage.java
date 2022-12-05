/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates serves as the basis for a beverage
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/


public abstract class Beverage {
	
	String beverageName;	//public beverage name, type, and size variables so classes that inherit may call upon it
	Type type;			
	Size size;
	private double basePrice = 2.0;	//base price of one drink
	private double sizePrice = 1.0;	//price to be added after adding one size

	/**
	 * Creates a beverage object using given values
	 * @param bevName name of beverage
	 * @param type of beverage
	 * @param size of beverag
	 */
	public Beverage(String bevName, Type type, Size size)
	{
		this.beverageName = bevName;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Abstract method that classes that inherit use to create their price calculations
	 * @return the price
	 */
	public abstract double calcPrice();
	
	/**
	 * toString method that represents a beverage object by displaying beverage name and size
	 */
	public String toString()
	{
		String str = "Beverage name: " + beverageName + ", Size: " + size + ", ";
		return str;
	}
	/**
	 * Compares two beverage objects to see if they are the same
	 * @param anotherBev other beverage object to be compared
	 * @return true or false depending on whether both beverages were the same
	 */
	public boolean equals(Beverage anotherBev)
	{
		boolean status = true;
		
		if(!(this.beverageName.equals(anotherBev.beverageName)))
		{
			status = false;
		}
		
		if(!(this.type.equals(anotherBev.type)))
		{
			status = false;
		}
		
		if(!(this.size.equals(anotherBev.size)))
		{
			status = false;
		}
		
		return status;
		
	}
	
	/**
	 * Calculates a new price based on the size
	 * @return the new price based on the size
	 */
	public double addSizePrice()
	{
		basePrice = 2.0;
		
		if(size.equals(Size.SMALL))
		{
			basePrice = 2.0;
		}
		
		if(size.equals(Size.MEDIUM))
		{
			basePrice += sizePrice;
		}
		
		if(size.equals(Size.LARGE))
		{
			basePrice += (sizePrice*2);
		}
		
		return basePrice;
		
	}
	
	/**
	 * Gets the base price
	 * @return the base price from the field
	 */
	public double getBasePrice()
	{
		return basePrice;
	}
	
	/**
	 * Gets the type of beverage
	 * @return the type of beverage from the field
	 */
	public Type getType()
	{
		return type;
	}
	
	/**
	 * Gets the beverage name
	 * @return the beverage name from the field
	 */
	public String getBevName()
	{
		return beverageName;
	}
	
	/**
	 * Gets the size of the beverage
	 * @return the size of beverage from the field
	 */
	public Size getSize()
	{
		return size;
	}
}
