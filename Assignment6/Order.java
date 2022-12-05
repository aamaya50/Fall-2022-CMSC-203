/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates an order
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import java.util.Random;
import java.util.ArrayList;


public class Order implements OrderInterface, Comparable {
	
	//variables used to create an order
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	Random r = new Random();
	int num;

	private Beverage beverage;
	private ArrayList<Beverage> order = new ArrayList<>();
	
	
	/**
	 * Constructor used to create order
	 * @param orderTime time of order
	 * @param orderDay day of order
	 * @param cust customer object to get name and age
	 */
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
	}
	
	/**
	 * Adds a new beverage of type coffee to the current order
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		
		beverage = new Coffee(bevName, size, extraShot, extraSyrup);
		order.add(beverage);
		
	}
	
	/**
	 * Adds a new beverage of type alcohol to the current order
	 */
	public void addNewBeverage(String bevName, Size size)
	{
		beverage = new Alcohol(bevName, size, isWeekend());
		order.add(beverage);
	}
	
	/**
	 * Adds new beverage of type smoothie to the current order
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		beverage = new Smoothie(bevName, size, numOfFruits, addProtein);
		order.add(beverage);
	}
	
	/**
	 * Generates an order number
	 * @return the order number
	 */
	public int generateOrder()
	{
		//gets a random number between 10000 and 90000
		int num = r.nextInt(10000) + 90000;
		return num;
	}
	
	/**
	 * Gets the randomly generated order number
	 * @return the order number
	 */
	public int getOrderNo()
	{
		return num;
	}
	
	/**
	 * Gets the order time
	 * @return the order time
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 * Gets the order day
	 * @return the order day
	 */
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * Gets the customer object from field
	 * @return the customer object
	 */
	public Customer getCustomer()
	{
		return cust;
	}
	
	/**
	 * Gets the order day
	 * @return the order day
	 */
	public Day getDay()
	{
		return orderDay;
	}
	
	/**
	 * Determines if it is the weekend based on the day of the week
	 */
	public boolean isWeekend()
	{
		boolean status = false;
		
		if(orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY))
		{
			status = true;
		}
		
		return status;
	}
	
	/**
	 * Gets the beverage listed in the itemNo of the order
	 * @return the beverage at the itemNo
	 */
	public Beverage getBeverage(int itemNo)
	{
		return order.get(itemNo);
	}
	
	/**
	 * Gets the amount of items in order
	 * @return the amount of items in the order
	 */
	public int getTotalItems()
	{
		return order.size();
	}
	
	/**
	 * Calculates the total of the current order
	 * @return the total of the order
	 */
	public double calcOrderTotal()
	{
		
		double total = 0;
		
		
		for(int i = 0; i < order.size(); i++)
		{
			total += order.get(i).calcPrice();
		}
		
		return total;
	}
	
	/**
	 *  Gets the amount of beverages of same type in an order
	 *  @return the amount of times the beverage was found in the order
	 */
	public int findNumOfBeveType(Type type)
	{
		int num = 0;
		for (int i = 0; i < order.size(); i++)
		{
			if(order.get(i).getType().equals(type))
			{
				num += 1;
			}
		}
		
		return num;
	}
	
	/**
	 * toString method that returns a string containing information about the order
	 */
	public String toString()
	{
		String str = "Order number: " + generateOrder() + ", Order time: " + getOrderTime() + ", Day: " + getOrderDay()
					  + ", Customer name: " + cust.getName() + ", Customer age: " + cust.getAge() + ", Beverages: ";
		
		for(int i = 0; i < order.size(); i++)
		{
			str = str + getBeverage(i).toString() + " ";
		}
		return str;
	}

	/**
	 * Compares this order number to another order's order number
	 * @param anotherOrder other order to compare order number to
	 * @return 0 if the order numbers are the same, 1 if this order number is greater than the other order's number, or -1 if this order number is less
	 * than the other order's number
	 */
	public int compareTo(Order anotherOrder) 
	{
		int num = 0;
		
		if(this.getOrderNo() > anotherOrder.getOrderNo())
		{
			num = 1;
		}
		else if(this.getOrderNo() < anotherOrder.getOrderNo())
		{
			num = -1;
		}
		
		
		return num;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
