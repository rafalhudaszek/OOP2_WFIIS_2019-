package Armia;
import java.util.ArrayList ;

import Armia.Rozkaz;

public class Czolg
{
	private ArrayList<Rozkaz> m_order_list;
	//private int m_range;
	
	public Czolg()
	{
		m_order_list = new ArrayList<Rozkaz>();
		//m_range = -1;
	}
	
	public void dodaj_rozkaz(Rozkaz obj)
	{
		m_order_list.add(obj);
		//m_range++;
	}

	public String ostatniRozkaz()
	{
		return "Ostatni rozkaz do mnie " + m_order_list.get(m_order_list.size()-1).inf_Rozkaz();
	}

	public String getAllOrders()
	{
		String tmp= "";
		for(int i = 0; i < m_order_list.size(); i++)
		{
			tmp+= m_order_list.get(i).inf_Rozkaz();
		}
        return tmp;
	} 
}	
