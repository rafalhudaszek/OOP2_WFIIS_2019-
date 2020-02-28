package Armia;
import java.util.ArrayList ;
import Armia.Czolg;

public class CentrumDowodzenia
{
	private ArrayList<Czolg> m_list;
	
	public CentrumDowodzenia()
	{
		m_list = new ArrayList<Czolg>();
	}

	public void zarejestrujCzolg(Czolg obj)
	{
		m_list.add(obj);
	}

	public void wydajRozkaz(String text_1, Rozkaz obj)
	{
		//System.out.println("Czolg nr " + text_1 + " otrzymal rozkazy:");
		String tmp = text_1.trim();
		int number = Integer.parseInt(tmp);
		
		m_list.get(number -1).dodaj_rozkaz(obj);
	}
	public String toString(){
        String toRet = "Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n";
        for(int i = 0; i < m_list.size(); i++){
            toRet += "Czolg nr " + (i+1) + " otrzymal rozkazy: \n" + m_list.get(i).getAllOrders() + "\n";
        }
        return toRet;
    }
}
