/*
* Class: CMSC 203
* Instructor: Professor Ping-Wei Tsai
*
* Description: This is a data element class that creates a plot based on the x, y, width, and depth values that are given, also determines
* if the plot is within the appropriate bounds, and that it will not overlap another plot
* 
* Due: 10/25/2022
*
* Platform/Compiler: Java/Eclipse
*I pledge that I have completed the programming assignment independently. I have no copied the code from a student or any source. I have not given my code to any student.
* Programmer: Anthony Amaya
*
*/





public class Plot {
	
	//variables to be used
	private int x;
	private int y;
	private int width;
	private int depth;

	/**
	 * No arg constructor class
	 */
	public Plot()
	{
		this.width = 1;
		this.depth = 1;
		
	}
	
	/**
	 * Constructor class that utilizes values plot values given
	 * @param x coordinate value
	 * @param y coordinate value
	 * @param width used to determine width
	 * @param depth used to determine depth
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Copy constructor
	 * @param otherPlot Plot object to be copied
	 */
	public Plot(Plot otherPlot)
	{
		
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
		
	}
	
	/**
	 * Determines if the plot is within the bounds which is 10 by 10.
	 * @param plot the plot to be evaluated if it is in bounds
	 * @return false if it is outside the bounds, and true if it is within the bounds
	 */
	public boolean encompasses(Plot plot)
	{
		//if statement that ensures the plot is not greater than a 10 by 10, and that the width and depth are not 0
		if((plot.getX() + plot.getWidth() < 10) && (plot.getY() + plot.getDepth() < 10) && (plot.getWidth() > 0) && (plot.getDepth() > 0))
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * Gets the depth
	 * @return the depth
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Gets the width
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Gets the x value
	 * @return the x value
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Gets the y value
	 * @return the y value
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Boolean method that determines if the plot overlaps another plot
	 * @param plot to be evaluated
	 * @return true if the plot overlaps another plot, false if the plot does not overlap another plot
	 */
	public boolean overlaps(Plot plot)
	{
		//if statement that compares the corners of each rectangle and determines if either is overlapping or completely inside one or the other
		if((plot.getX() < this.x + this.width) && (plot.getX() + plot.getWidth() > this.x) && (plot.getY() < this.y + this.depth) && (plot.getY() + plot.getDepth() > this.y))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Sets the depth
	 * @param depth to set
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * Sets the width
	 * @param width to be set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * Sets the x value
	 * @param x value to be set
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Sets the y value
	 * @param y value to be set
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * toString method that returns the x, y, width, and depth of a plot object
	 */
	public String toString()
	{
					 
		String str = "" + getX() + "," + getY() + "," + getWidth() + "," + getDepth();
		
		return str;
	}
	
	
	
	
}
