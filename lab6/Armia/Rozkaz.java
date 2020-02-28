package Armia;

public class Rozkaz
{
	private String m_order;
	
	public Rozkaz(String order)
	{
		m_order = order;
	}

	public String inf_Rozkaz()
	{
		return m_order+ "\n";
	}
	

}
