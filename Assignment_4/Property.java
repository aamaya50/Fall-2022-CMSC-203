/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a data element class that creates a Property using a given property name, city it is located in, the owner of
* the property, and it can also take x, y, width, and depth values to create a plot of the property
* 
* Due: 10/25/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/




public class Property {
	
	//Variables to be used
	private String propertyName = "";
	private String city = "";
	private String owner = "";
	private double rentAmount;
	private int x;
	private int y;
	private int width;
	private int depth;
	private Plot plot;
	
	/**
	 * No arg constructor for the property class
	 * Sets important variables to empty string
	 * Creates new default plot
	 */
	public Property()
	{
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.plot = new Plot();
	}
	
	/**
	 * Property class constructor that sets the property name, city, rent amount, and owner respectively
	 * Creates default plot
	 * @param propertyName name of property
	 * @param city city property is located in
	 * @param rentAmount amount of rent at that property
	 * @param owner name of property owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	/**
	 * Property constructor that sets the property name, city, rent amount, owner respectively, and creates a plot using given parameters
	 * @param propertyName name of property
	 * @param city city property is located in
	 * @param rentAmount rent amount at that property
	 * @param owner of the property
	 * @param x value to be set in plot
	 * @param y value to be set in plot
	 * @param width of rectangle in plot
	 * @param depth of rectangle in plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
		this.plot = new Plot(x, y, width, depth);
		
	}
	
	/**
	 * Property class copy constructor
	 * @param otherProperty Property object to be copied
	 */
	public Property(Property otherProperty)
	{
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.owner = otherProperty.owner;
		this.rentAmount = otherProperty.rentAmount;
		this.x = otherProperty.x;
		this.y = otherProperty.y;
		this.width = otherProperty.width;
		this.depth = otherProperty.depth;
		this.plot = otherProperty.plot;				
		
	}
	
	/**
	 * gets city property is located in
	 * @return city name
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Gets owner of property
	 * @return property owner name
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * Gets the property name
	 * @return the name of the property
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * Gets the plot 
	 * @return the plot object
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * Gets the rent amount at a property
	 * @return the rent amount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/**
	 * toString method that displays a property's name, city, owner, and rent amount
	 */
	public String toString()
	{
		String str = "" + propertyName + "," + city + "," + owner + "," + rentAmount;
		
		return str;
	}
	

}
