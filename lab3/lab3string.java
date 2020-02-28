public class lab3string
{
	public static int dlugosc(String a)
	{
		return a.length();
	}

	public static int ile_razy_literka_wystepuje(String a, char literka)
	{
		int wynik=0;
		for(int i=0; i< a.length(); i++)
		{
			if(a.charAt(i)== literka)
			{
				wynik++;	
			}
		}
		return wynik;
	}

	public static boolean czy_takie_same(String a, String b)
	{
		return a.equals(b);
	}

	public static String wspak(String a)
	{
		String odwrotnie= new String();
		for (int i = a.length()-1; i >=0; i--)
		{
			odwrotnie+= a.charAt(i);
		}
		return odwrotnie;
	}
	
	public static boolean czy_plaindrom(String a)
	{
		String odwrotnie = new String(wspak(a));
		System.out.println(odwrotnie);
		if(a.equals(odwrotnie))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean czy_abecadlowe(String a)
	{
		char znak = a.charAt(0);
		for(int i = 1; i<a.length(); i++)
		{
			if(a.charAt(i) > znak)
			{}
			else
			{
				return false;
			}
		}
		return true;
	}

	public static String rot13(String a)
	{
		StringBuffer b = new StringBuffer();
		for(int i = 0; i < a.length(); i++)
		{
			if(Character.isLetter(a.charAt(i))==false)
			{
				b.append(a.charAt(i));
			}
			else
			{
				if(Character.isLowerCase(a.charAt(i)))
				{
					b.append(('a'+ a.charAt(i))%26+'a');
				}
				else
				{
					b.append(('A'+a.charAt(i))%26 +'A');
				}
			}			

		}
		String c= new String(b);
		return c;
	}

}
