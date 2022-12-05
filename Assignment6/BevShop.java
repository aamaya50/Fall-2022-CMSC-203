/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This class creates the orders for a bevshop
* 
* Due: 12/06/2022
*
* Platform/Compiler: Java/Eclipse
* I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/

import java.util.ArrayList;


public class BevShop implements BevShopInterface {
	
	private ArrayList<Order> order = new ArrayList<>();	//array list used to hold all orders
	Order o;	//order instance variable
	
	/**
	 * Checks if the time is valid or between 8 and 23
	 * @param time is the time of order
	 * @return whether it is indeed a valid time
	 */
	public boolean isValidTime(int time)
	{
		boolean status = false;
		
		if(time > 8 && time < 23)
		{
			status = true;
		}
		
		return status;
		
	}
	
	/**
	 * @return the constant value for the maximum number of fruit that can be put in a smoothie
	 */
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	/**
	 * Gets the minimum age for ordering alcohol from the interface
	 * @return the minimum age for ordering alcohol
	 */
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	/**
	 * Determines if the maximum number of fruits in a smoothie has been reached
	 * @param numOfFruits the number of fruits put into the smoothie
	 * @return true or false if the max number of fruits has been reached
	 */
	public boolean isMaxFruit(int numOfFruits)
	{
		boolean status = false;
		
		if(numOfFruits > getMaxNumOfFruits())
		{
			status = true;
		}
		else
		{
			status = false;
		}
		
		return status;
	}
	
	/**
	 * Gets the maximum amount that someone can order an alcoholic drink
	 * @return the max number of alcohol per order
	 */
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * Determines if the person is able to order more alcohol or has reached the limit
	 * @return true or false if the person is able to order more alcohol
	 */
	public boolean isEligibleForMore()
	{
		boolean status = true;
		
		if(getNumOfAlcoholDrink() >= MAX_ORDER_FOR_ALCOHOL)
		{
			status = false;
		}
		
		return status;

	}
	
	/**
	 * Gets the number of alcohol drinks ordered
	 * @return the number of alcohol drinks that has been orderd for the current order
	 */
	public int getNumOfAlcoholDrink()
	{
		int total = 0;
		
		for(int i = 0; i < order.size(); i++)
		{
			if(order.get(i).findNumOfBeveType(Type.ALCOHOL) > MAX_ORDER_FOR_ALCOHOL)
			{
				total = MAX_ORDER_FOR_ALCOHOL;
				i = order.size();
			}
			else
			{
				total = order.get(i).findNumOfBeveType(Type.ALCOHOL);
			}
		}
		
		return total;
		
	}
	
	/**
	 * Determines if the customer is of age to drink
	 * @param age of the customer
	 * @return true or false if the customer is of age
	 */
	public boolean isValidAge(int age)
	{
		boolean status = true;
		if(age < MIN_AGE_FOR_ALCOHOL)
		{
			status = false;
		}
		return status;
	}
	
	/**
	 * Begins a new order using the customer, time, and day
	 * @param time of the order
	 * @param day of the order
	 * @param customerName name of customer
	 * @param customerAge age of customer
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		Customer cust = new Customer(customerName, customerAge);
		Order orderUp = new Order(time, day, cust);
		order.add(orderUp);
	}
	
	/**
	 * Adds a coffee to the order if the customer orders coffee
	 * @param bevName beverage name
	 * @param size of beverage
	 * @param extraShot determines if the customer wants an extra shot
	 * @param extraSyrup determines if the customer wants extra syrup
	 */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		Order orders = order.get(order.size()-1);
		orders.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	/**
	 * Adds alcohol to the current order if the customer orders alcohol
	 * @param bevName name of beverage
	 * @param size of beverage
	 */
	public void processAlcoholOrder(String bevName, Size size)
	{
		Order orders = order.get(order.size()-1);
		orders.addNewBeverage(bevName, size);
	}
	
	/**
	 * Adds a smoothie to the current order if the customer orders a smoothie
	 * @param bevName name of beverage
	 * @param size of beverage
	 * @param numOfFruits number of fruits to be added
	 * @param addProtein determines if the customer wants to add protein to the smoothie or not
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruit, boolean addProtein)
	{
		Order orders = order.get(order.size()-1);
		orders.addNewBeverage(bevName, size, numOfFruit, addProtein);
	}
	
	/**
	 * Locate an order based on the order number, if the order is not found then -1 is returned
	 * @param orderNo the order number to return order from
	 * @return the order at the order number
	 */
	public int findOrder(int orderNo)
	{	
		
		int num = -1;
		
		for(int i = 0; i < order.size(); i++)
		{
			if(order.get(i).getOrderNo() == orderNo)
			{
				num = i;
				i = order.size();
			}
		}
		
		return num;
		
	}
	
	/**
	 * Locates an order in the list of orders and returns the total value on the order
	 * @param orderNo the order number to get total from
	 * @return the total on order at a certain order number
	 */
	public double totalOrderPrice(int orderNo)
	{
		double total = 0.0;
		int num = findOrder(orderNo);
		Order o = null;
				
		if(num != -1)
		{
			total = order.get(num).calcOrderTotal();
		}
		
		return total;
	}
	
	/**
	 * Calculates the total sale of all orders in order list
	 * @return the total of all orders
	 */
	public double totalMonthlySale()
	{
		double total = 0;
		double totalReal = 0;
		
		
		for(int i = 0; i < order.size(); i++)
		{
			total += order.get(i).calcOrderTotal();
		}
		
		return total;
	}
	
	/**
	 * Returns the total number of orders within the month
	 */
	public int totalNumOfMonthlyOrders()
	{
		return order.size();
	}
	
	/**
	 * Gets the current order
	 * @return the current order
	 */
	public Order getCurrentOrder()
	{
		return order.get(order.size()-1);
	}
	
	/**
	 * Gets the order at a certain index
	 * @param index of certain order
	 * @return the order at a certain index
	 */
	public Order getOrderAtIndex(int index)
	{
		return order.get(index);
	}
	
	/**
	 * Sorts the orders
	 */
	public void sortOrders()
	{
		
		int min;
		Order od;
		
		for(int i = 0; i < order.size(); i++)
		{
			min = i;
			for(int k = i + 1; k < order.size(); k++)
			{
				if(order.get(k).compareTo(order.get(min)) < 0)
				{
					min = k;
				}
			}
			
			od = order.get(min);
			order.set(min,  order.get(i));
			order.set(i,  od);
			
		}
		
		
	}
	
	public String toString()
	{
		String str = ""; 
		
		for(int i = 0; i < order.size(); i++)
		{
			str = str + order.get(i).toString() + " ";
		}
		
		str = str + "Total monthly sale: " + totalMonthlySale();
		
		return str;
	}
	
	

}
