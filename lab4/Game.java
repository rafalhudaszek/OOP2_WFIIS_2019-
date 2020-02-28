public class Game
{	
    public int x;
	public int y;
	private int midX;
    private int midY;
    public int steps;
    public int preset;
    public char[][] board;
    
	public Game(int x, int y, int steps, int preset)
	{
		this.x= x;
		this.y = y;
		this.midX = x/2;
		this.midY = y/2;
		this.steps = steps;
		this.preset = preset;
	
		board = new char[y][x];
	}
	
	public class Obiekt
	{
		public boolean choice;
		public int pos_x;
		public int pos_y;
		public Obiekt()
		{
			pos_x = midX;
			pos_y = midY;
		}
		public Obiekt(int x, int y)
		{
			pos_x = x;
			pos_y = y;
		}

	}
    
    public class List_Obiekt
	{
		public Obiekt lista[];
		public List_Obiekt(int x, int y)
		{
			lista = new Obiekt[8];
			Obiekt pierwszy = new Obiekt (x -1, y -1);
			lista [0] = pierwszy;
			
			Obiekt drugi = new Obiekt (x -1, y );
			lista [1] = drugi;
			
			Obiekt trzeci = new Obiekt (x -1, y +1);
			lista [2] = trzeci;
			
			Obiekt czwarty= new Obiekt (x , y -1);
			lista [3] = czwarty;
			
			Obiekt piaty= new Obiekt (x , y +1);
			lista [4] = piaty;
			
			Obiekt szusty = new Obiekt (x +1 , y - 1);
			lista [5] = szusty;
			
			Obiekt siodmy = new Obiekt (x +1 , y );
			lista [6] = siodmy;
			
			Obiekt osmy= new Obiekt (x +1, y +1);
			lista [7] = osmy;
		}
	}

	public class Zapamietywanie_obiektow
	{
			public Obiekt trasa[];
			public int size;
			public int actuall_size;
			
			public Zapamietywanie_obiektow( int x, int y)
			{
				size = (x-1) * (y-1);
				trasa = new Obiekt[size];
				actuall_size = 0;
				
			}
			
			public void wypelnij(int x, int y, boolean i)
			{
				
				Obiekt tmp = new Obiekt (x ,y);
				tmp.choice = i;
				trasa[actuall_size] = tmp; 
				actuall_size++;
			}
			
			
			
			public void dzien_Sadu()
			{
				for(int i = 0; i < actuall_size; i++)
				{
					if(trasa[i].choice)
					{
						resurrect(trasa[i]);
					}
					else
					{
						kill(trasa[i]);
					}
				}
			}
	}

	public List_Obiekt friends_list(Obiekt a)
	{
		if(a.pos_x == 0|| a.pos_y == 0 || a.pos_x == x || a.pos_y == y)
		{
			System.out.println("Błąd programu, zly sasiad" + a.pos_x + " " + a.pos_y);
		}
		return new List_Obiekt(a.pos_x, a.pos_y);
		
	}

	public boolean zyje_czy_nie(Obiekt a)
	{
		if(board[a.pos_y][a.pos_x] == 'X')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean zmieniac_czy_nie(Obiekt a)
	{
		int licznik=0;
		List_Obiekt lista = friends_list(a);
		for(int i = 0; i < 8; i ++)
		{
			if(zyje_czy_nie(lista.lista[i]))
			{
				licznik++;
			}
		}
		
		if(zyje_czy_nie(a))
		{
			
			if(licznik==2||licznik==3)
			{ 
				return true;
			}
			else
			{
				return false;
			}
		}
		
		if(licznik==3)
		{ 
			return true;
		}
		else
		{
			return false;
		}
	}
		
	public static void clearScreen() 
    {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	} 
    public void petla()
	{
		for(int g = 0; g<=steps; g++)
		{
			Zapamietywanie_obiektow tmp = new Zapamietywanie_obiektow(y, x);
			tmp.actuall_size = 0;
			for(int i = 1; i<y-1; i++  )
			{	for(int j=1; j<x-1; j++)
				{

					if(zmieniac_czy_nie(new Obiekt(i, j) ))
					{
						tmp.wypelnij(i, j, true);
					}
					else
					{	
						tmp.wypelnij(i, j, false);
					}
				}
			}
			tmp.dzien_Sadu();
			//clearScreen();
			show();
            break_line();
		}	

	}
	
	public void wybor()
	{
		switch(preset)
		{
		case 1:{
			parset_1();
			break;
		}
		case 2:{
			parset_2();
			break;
		}
		case 3:{
			parset_3();
			break;
		}
		case 4:{
			parset_4();
			break;
		}
		default:{
			System.out.println("zly parset");
		}
				
		}
	}

    public void fill()
	{
		for(int i =0; i<y; i++)
		{
			for(int j=0; j<x; j++)
			{
				board[i][j] = '.';
			}
		}
	}

    public void resurrect(Obiekt a)
	{
		board[a.pos_y] [ a.pos_x] = 'X';
	}
	
	public void kill(Obiekt a)
	{
		board[a.pos_y] [ a.pos_x] = '.';
	}
	
	public void show()
	{
		for(int i =0; i<y; i++)
		{
			for(int j=0; j<x; j++)
			{
				System.out.printf("%c ", board[i][j]);
			}
			System.out.println("");
		}	
		System.out.println("");
	}

    public void break_line()
    {
        System.out.println("--------.-------");
    }
	
	public void run()
	{
		fill();
		show();
		wybor();
		show();
		petla();
	}
	
		public void parset_1()
	{
		board[midY-1][midX-1] = 'X';
		board[midY-1][midX] = 'X';
		board[midY][midX-1] = 'X';
		board[midY][midX+1] = 'X';
		board[midY+1][midX] = 'X';
	}

	public void parset_2()
	{
		board[midY][midX -1] ='X';
		board[midY][midX] ='X';
		board[midY][midX +1] ='X';
	}
	
	public void parset_3()
	{
		board[midY-1][midX-1] = 'X';
		board[midY-1][midX] = 'X';
		board[midY-1][midX+1] = 'X';
		board[midY][midX-1] = 'X';
		board[midY+1][midX] = 'X';
	}
	public void parset_4()
	{
		board[midY-2][midX-6] = 'X';
		board[midY-3][midX-6] = 'X';
		board[midY-4][midX-6] = 'X';
		
		board[midY-6][midX-4] = 'X';
		board[midY-6][midX-3] = 'X';
		board[midY-6][midX-2] = 'X';
		
		board[midY-4][midX-1] = 'X';
		board[midY-3][midX-1] = 'X';
		board[midY-2][midX-1] = 'X';
		
		board[midY-1][midX-2] = 'X';
		board[midY-1][midX-3] = 'X';
		board[midY-1][midX-4] = 'X';
		
		
		
		board[midY-2][midX+6] = 'X';
		board[midY-3][midX+6] = 'X';
		board[midY-4][midX+6] = 'X';
		
		board[midY-6][midX+4] = 'X';
		board[midY-6][midX+3] = 'X';
		board[midY-6][midX+2] = 'X';
		
		board[midY-4][midX+1] = 'X';
		board[midY-3][midX+1] = 'X';
		board[midY-2][midX+1] = 'X';
		
		board[midY-1][midX+2] = 'X';
		board[midY-1][midX+3] = 'X';
		board[midY-1][midX+4] = 'X';
		
		
		board[midY+2][midX-6] = 'X';
		board[midY+3][midX-6] = 'X';
		board[midY+4][midX-6] = 'X';
		
		board[midY+6][midX-4] = 'X';
		board[midY+6][midX-3] = 'X';
		board[midY+6][midX-2] = 'X';
		
		board[midY+4][midX-1] = 'X';
		board[midY+3][midX-1] = 'X';
		board[midY+2][midX-1] = 'X';
		
		board[midY+1][midX-2] = 'X';
		board[midY+1][midX-3] = 'X';
		board[midY+1][midX-4] = 'X';
		
		
		
		board[midY+2][midX+6] = 'X';
		board[midY+3][midX+6] = 'X';
		board[midY+4][midX+6] = 'X';
		
		board[midY+6][midX+4] = 'X';
		board[midY+6][midX+3] = 'X';
		board[midY+6][midX+2] = 'X';
		
		board[midY+4][midX+1] = 'X';
		board[midY+3][midX+1] = 'X';
		board[midY+2][midX+1] = 'X';
		
		board[midY+1][midX+2] = 'X';
		board[midY+1][midX+3] = 'X';
		board[midY+1][midX+4] = 'X';

		
	}
}
