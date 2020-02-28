/**
* Klasa Point opisuje punkt
* @ author Rafal Hudaszek
*/

public class Point extends Shape
{
	private double x;
	private double y;
	public Point(double x, double y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public String toString()
	{
		return  "[" + x + ", " + y + "]";
	}
	
	public double area()
	{
		return 0;
	}
	
	public double volume()
	{
		return 0;
	}
	
	public double get_x()
	{
		return x;
	}

	public double get_y()
	{
		return y;
	}
}
