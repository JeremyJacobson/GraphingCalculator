package model;

/**
 * Creates an X/Y Point. Unlike the java.awt.Point class, this Point contains two doubles
 * 
 * @author jeremyjacobson
 *
 */
public class Point 
{
	private double x;
	private double y;
	
	/**
	 * Creates the point
	 * 
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the X value in the point
	 * 
	 * @return
	 */
	public double getX() 
	{
		return x;
	}

	/**
	 * Returns the Y value in the point
	 * 
	 * @return
	 */
	public double getY() 
	{
		return y;
	}

	/**
	 * Returns the String in the format:
	 * Point [{X},{Y}]
	 * Only used for testing, not needed for calculator to work
	 * 
	 */
	@Override
	public String toString() 
	{
		return "Point [" + x + ", " + y + "]";
	}
	
}
