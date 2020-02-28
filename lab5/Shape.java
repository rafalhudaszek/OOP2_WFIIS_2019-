/**
* Klasa abstrakcyjna 
* @ author Rafal Hudaszek
*/
public abstract class Shape
{
    /**
    * metoda zwracajaca nazwe obiektu
    * @return nazwa obiektu
    */
	public String getName()
    {
        return getClass().getName();
    }

    /**
    * metoda zwracajaca informacje o obiekcie
    * @return informacje
    */
	public abstract String toString();
	
    /**
    * metoda zwracajaca pole powierzchni szescianu
    * @return wartość pola powierzchni szescianu
    */
	public abstract double area();
	
    /**
    * metoda zwracajaca objetość
    * @return wartość objętości
    */
	public abstract double volume();
	
}
