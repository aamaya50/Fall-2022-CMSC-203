/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a data manager class that allows the GUI to add and display the property onto the plot using methods from both the plot
* and property data element classes
* 
* Due: 10/25/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/





import java.util.ArrayList;


public class ManagementCompany {
	
	//constant variables
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_DEPTH = 10;
	public static final int MGMT_WIDTH = 10;
	
	//Arraylist that holds Property objects
	private ArrayList<Property> prop;
	
	//Variables to be used
	private String name = "";
	private String taxID = "";
	private double mgmFee;
	private int x;
	private int y;
	private int width;
	private int depth;
	
	//plot and property variables to be used to hold instances of their respective object
	private Plot plot;
	private Property p;
	
	/**
	 * No arg ManagementCompany class constructor
	 * Sets variables to empty or 0
	 * Creates default plot with max depth and max width
	 * instantiates property arraylist to the max amount of properties
	 */
	public ManagementCompany()
	{
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0;
		this.plot = new Plot(x, y, 10, 10);
		this.plot.setDepth(MGMT_DEPTH);
		this.plot.setWidth(MGMT_WIDTH);
		
		this.prop = new ArrayList<Property>(MAX_PROPERTY);

	}
	
	/**
	 * ManagementCompany constructor that takes the name, taxID, and management fee
	 * @param name sets the name to it's respective variable
	 * @param taxID sets the taxID to the respective variable
	 * @param mgmFee sets the mgmFee to the respective variable
	 * initializes property arraylist to the max amount of properties
	 * creates new default plot with max depth and max width
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		this.prop = new ArrayList<Property>(MAX_PROPERTY);
				
		this.plot = new Plot(x, y, MGMT_DEPTH, MGMT_DEPTH);
		
	}
	
	/**
	 * ManagementCompany class constructor that sets the name, taxID, and management fee respectively.
	 * Creates new plot using given x, y, width, and depth values
	 * Initializes arraylist Property to max property 
	 * @param name sets the name of the company
	 * @param taxID sets the taxID
	 * @param mgmFee sets the mgmFee
	 * @param x value used in new plot
	 * @param y value used in new plot
	 * @param width used in new plot
	 * @param depth used in new plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
			
		this.plot = new Plot(x, y, width, depth);
		
		this.prop = new ArrayList<Property>(MAX_PROPERTY);
		
	}

	/**
	 * ManagementCompany class copy constructor
	 * Initializes Property arraylist to max property
	 * @param otherCompany to be copied
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		
		this.prop = new ArrayList<Property>(MAX_PROPERTY);
		
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.x = otherCompany.x;
		this.y = otherCompany.y;
		this.width = otherCompany.width;
		this.depth = otherCompany.depth;
		this.plot = otherCompany.plot;
		
	}
	
	/**
	 * Adds property to arraylist of Property object
	 * @param name of property 
	 * @param city property is located in
	 * @param rent of property
	 * @param owner of property
	 * @return index of where property was placed in Property arraylist or a negative number depending on the error
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		//property variable used to create property to be compared later. Created using method parameters
		p = new Property(name, city, rent, owner);
		int returnValue = 0;
		
		boolean status = false;
	
		//for loop that iterates through each property object in the arraylist of properties to determine if they overlap anywhere
		//sets boolean variable equal to true if it does overlap
		for (int k = 0; k < prop.size(); k++)
		{
			if (prop.get(k).getPlot().overlaps(p.getPlot()) == true)
			{
				status = true;
			
			}
		}		
		
		//if properties arraylist is full then set returnvalue variable to -1
		if(isPropertiesFull() == true)
		{
			returnValue = -1;
		}
		//if the plot is not within bounds then return -3
		else if(plot.encompasses(plot))
		{
			returnValue = -3;
		}
		//if the property was determined to be overlapping another plot then set returnValue = -4
		else if (status == true)
		{
			returnValue = -4;
		}
		//if none of the previous conditions were true then add p to the property arraylist and set returnValue equal to the arraylist size - 1
		else if (status == false && returnValue == 0)
		{
			prop.add(p);
			returnValue = prop.size() -1;	
		}
		
		return returnValue;
		
	}
	
	/**
	 * Adds property to arraylist of Properties if certain conditions are met 
	 * @param name of property 
	 * @param city property is located in
	 * @param rent of property
	 * @param owner of property
	 * @param x value used in plot
	 * @param y value used in plot
	 * @param width of the plot
	 * @param depth of the plot
	 * @return index of where property was placed in Property arraylist or a negative number depending on the error
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		//property variable used to create property and plot to be compared later. Created using method parameters
		p = new Property(name, city, rent, owner, x, y, width, depth);

		int returnValue = 0;	

		boolean status = false;
		
		//for loop that iterates through each property object in the arraylist of properties to determine if they overlap anywhere
		//sets boolean variable equal to true if it does overlap
		for (int k = 0; k < prop.size(); k++)
		{
			if (prop.get(k).getPlot().overlaps(p.getPlot()) == true)
			{
				status = true;
			}
		}		
		
		//if properties arraylist is full then set returnvalue variable to -1
		if(isPropertiesFull() == true)
		{
			returnValue = -1;
		}
		//if the plot is not within bounds then return -3
		else if(plot.encompasses(plot))
		{
			returnValue = -3;
		}
		//if the property was determined to be overlapping another plot then set returnValue = -4
		else if (status == true)
		{
			returnValue = -4;
			
		}
		//if none of the previous conditions were true then add p to the property arraylist and set returnValue equal to the arraylist size - 1
		else if (status == false && returnValue == 0)
		{
			prop.add(p);
			returnValue = prop.size() - 1;					
		}
		
		return returnValue;
		
	}
	
	/**
	 * Adds property to property arraylist if conditions are met
	 * @param property object to be added
	 * @return the index of where the property object was added
	 */
	public int addProperty(Property property)
	{

		int returnValue = 0;
		
		boolean status = false;
		
		//for loop that iterates through each property object in the arraylist of properties to determine if they overlap anywhere
		//sets boolean variable equal to true if it does overlap
		for (int k = 0; k < prop.size(); k++)
		{
			if (prop.get(k).getPlot().overlaps(property.getPlot()) == true)
			{
				status = true;
			}
		}		
		
		//if properties arraylist is full then set returnvalue variable to -1
		if(isPropertiesFull() == true)
		{
			returnValue = -1;
		}
		//if the property in the parameter is null the set returnValue equal to -2
		else if(property == null)
		{
			returnValue = -2;
		}
		//if the plot is not within bounds then return -3
		else if(plot.encompasses(property.getPlot()))
		{
			returnValue = -3;
		}
		//if the property was determined to be overlapping another plot then set returnValue = -4
		else if (status == true)
		{
			returnValue = -4;
		}
		//if none of the previous conditions were true then add the property to the property arraylist and set returnValue equal to the arraylist size - 1
		else if (status == false && returnValue == 0)
		{
			prop.add(property);
			returnValue = prop.size() - 1;
		}
		
		return returnValue;
	
	}
	
	/**
	 * Boolean method that returns true if the property arraylist is greater than the max property amount
	 * @return true or false
	 */
	public boolean isPropertiesFull()
	{
		
		if(prop.size() > MAX_PROPERTY-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	/**
	 * Boolean method that determines if the management fee is within 0-100
	 * @return true or false
	 */
	public boolean isManagementFeeValid()
	{
		if(mgmFee > 0 && mgmFee < 100)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	/**
	 * Gets the property object from the property arraylist with the highest rent amoount
	 * @return property with the highest rent amount
	 */
	public Property getHighestRentProperty()
	{
		int i = 0;
		
		//compares each property in the property arraylist and their rent amount setting the higher rent amount the property variable to be returned
		Property highest = prop.get(i);
		
		for(i = 1; i < prop.size(); i++)
		{
			
			if (prop.get(i).getRentAmount() > highest.getRentAmount() )
			{
				highest = prop.get(i);
			}
			
		}
		
		return highest;
		
	}
	
	/**
	 * Gets the management fee per property
	 * @return the mangement fee per property
	 */
	public double getMgmFeePer()
	{
		//uses the getTotalRent() method to get all rents added up and multiples them by the mgmfee and divides by 100
		double mgmFeePer = (getTotalRent() * mgmFee)/100;
		
		return mgmFeePer;
	}
	
	/**
	 * Gets the total rent of all properties in the Property arraylist using an accumulator variable
	 * @return the total rent from all properties
	 */
	public double getTotalRent()
	{
		int total = 0;
		
		//for loop to go through every property object in the property arraylist
		for(int i = 0; i < prop.size(); i++)
		{
			total += prop.get(i).getRentAmount();
		}
		
		return total;
	}
	
	/**
	 * gets property arrarylist
	 * @return the property arraylist
	 */
	public ArrayList<Property> getProperties()
	{
		return prop;
	}
	
	/**
	 * Gets the amount of properties stored in the Property arraylist
	 * @return the amount of properties
	 */
	public int getPropertiesCount()
	{
		int numOfProp = 0;
		
		//for loop to go through each index in the property arraylsit
		for(int i = 0; i < prop.size(); i++)
		{
			numOfProp += 1;
		}
		
		return numOfProp;
	}
	
	/**
	 * Gets the name of the company
	 * @return the name of the company
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the plot
	 * @return plot
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * Gets the taxID
	 * @return taxID
	 */
	public String getTaxID()
	{
		return taxID;
	}
	
	/**
	 * Removes the last property in the arraylist
	 */
	public void removeLastProperty()
	{
		int index = prop.size() - 1;
		prop.remove(index);
		
	}
	
	/**
	 * toString method that returns the information of all properties within the array
	 */
	public String toString()
	{
		
		String temp = "";
		
		
		for(int i = 0; i < prop.size(); i++)
		{
			
			temp += "" + prop.get(i).getPropertyName() + ", " +
					prop.get(i).getCity() + ", " +
					prop.get(i).getOwner() + ", " +
					prop.get(i).getRentAmount() + "\n";
			
		}
		
		String str = "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n" +
					  "---------------------------------------------------------------------\n"
					  + temp
					  +"---------------------------------------------------------------------\n"
					  + "Total mangement fee: " + getMgmFeePer();
		
		return str;

		
	}
	

	
	
	
	
	
}
