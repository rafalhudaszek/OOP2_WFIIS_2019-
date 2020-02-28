/**
* Klasa Square opisuje kwadrat
* @ author Rafal Hudaszek
*/

public class Square extends Point
{
	private double side;
	public Square(double side, double x, double y)
	{
		super(x, y);
		this.side = side;
	}
	
	
	public String toString()
	{
		return  "Corner = [" + get_x() + ", " + get_y() + "]; side = " + side;
	}
	
	public double area()
	{
		return side * side;
	}
	
	public double volume()
	{
		return 0;
	}
	
	public double get_side()
	{
		return side;
	}
	
}
