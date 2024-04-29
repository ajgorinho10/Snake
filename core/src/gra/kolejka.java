package gra;

/**
 * Obiekt na podstawie ktorego jest stworzony stos do obslugi weza
 */
public class kolejka {
	
		/**
	 	* Pozycja x
	 	*/
		public int x; 
		
		/**
		 * Pozycja y
		 */
		public int y; 
		
		/**
		 * Kierunek
		 */
		public int dir; 

		/**
		 * Konstruktor trojargumentowy
		 * @param wx pozycja x
		 * @param wy pozycja x
		 * @param wdir kierunek
		 */
		public kolejka(int wx,int wy,int wdir)
		{
			this.x = wx;
			this.y = wy;
			this.dir = wdir;
		}

		/**
		 * Konstruktor pusty
		 */
		public kolejka()
		{

		}
		
		/**
		 * Zmiana wartosci weza
		 * @param wx nowa pozycja x
		 * @param wy nowa pozycja y
		 * @param wdir nowy kierunek
		 */
		public void zmiana(int wx,int wy,int wdir)
		{
			this.x = wx;
			this.y = wy;
			this.dir = wdir;
		}

}
