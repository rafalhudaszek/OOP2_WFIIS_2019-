/**
* Klasa Cube opisuje sześcian
* @ author Rafal Hudaszek
*/
public class Cube extends Square
{
    /** Objetosc szescianu */
	private double volume;

    /**
    * Konstruktor
    * @param side dlugosc boku szescianu
    * @param x wpółrzedna na osi x
    * @param y współrzedna na osi y
    */
	public Cube( double side, double x, double y)
	{
		super(side, x, y );
		this.volume = side * side * side;
	}
	
	
    /**
    * metoda zwracajaca informacje o obiekcie
    * @return informacje
    */
	public String toString()
	{
		return  "Corner = [" + get_x() + ", " + get_y() + "]; side = " + get_side() + "; depth = "+ get_side();
	}
	
    /**
    * metoda zwracajaca pole powierzchni szescianu
    * @return wartość pola powierzchni szescianu
    */
	public double area()
	{
		return get_side() * get_side() * 6;
	}
	
    /**
    * metoda zwracajaca objetość
    * @return wartość objętości
    */
	public double volume()
	{
		return volume;
	}
	
}
