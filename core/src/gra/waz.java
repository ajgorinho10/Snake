package gra;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * Obiekt odpowiedzialny za obsluge i przechowywanie weza
 */
public class waz {

	/**
	 * Pole pomocnicze
	 */
	public kolejka ogon_add;
	
	/**
	 * Pole pomocnicze
	 */
	public kolejka ogon_old;
	
	/**
	 * Pole pomocnicze
	 */
	public kolejka ogon_s;
	
	/**
	 * Stos przechowuje on calego weza
	 */
	public Stack<kolejka> ogon;
	
	/**
	 * Iterator do przegladania weza
	 */
	public Iterator<kolejka> it;
	
	/**
	 * Iterator do przegladania weza
	 */
	public Iterator<kolejka> it1;

	/**
	 * Okresla czy gracz przegral
	 */
	public boolean gra;
	
	/**
	 * Jesli jest watosc true to wyswietlany jest ekran poczatkowy
	 */
	public boolean poczatek;
	
	/**
	 * Szybkosc poruszania weza
	 */
	public int speed;
	
	/**
	 * dlugosc weza
	 */
	public int dlugosc;
	
	/**
	 * Punty gracza
	 */
	public int punkty;
	
	/**
	 * Maksymalne punkty zdobyte podczas sesji
	 */
	public int punktyMax;
	
	/**
	 * Pozycja glowy x
	 */
	public int head_x;
	
	/**
	 * Pozycja glowy y
	 */
	public int head_y;
	
	/**
	 * Pozycja Jablka
	 */
	public int[] applexy;
	
	/**
	 * Kierunek glowy weza
	 */
	public int kierunek;
	
	/**
	 * Sluzy do podzialu czasu
	 */
	public float timeSeconds;
	
	/**
	 * Sluzy do podzialu czasu
	 */
	public float period;
	
	/**
	 * Generowanie liczb losowych
	 */
	public Random r;
	
	/**
	 * Konstruktor przypisanie odpowiednich wartosci do pol obslugi weza
	 */
	public waz() {
		ogon_add = new kolejka(100,100,1);
		ogon_old = new kolejka(0,0,0);
		ogon_s= new kolejka(0,0,0);
		ogon = new Stack<>();
		it = ogon.iterator();
		it1 = ogon.iterator();

		gra = false;
		poczatek = true;
		speed=40;
		dlugosc=0;
		punkty=2;
		punktyMax = 0;
		applexy = new int[2];
		kierunek=2;
		timeSeconds =0.0f;
		period = 0.07f;
		r = new Random();
		applexy[0] = r.nextInt(20)*40;
		applexy[1] = r.nextInt(15)*40;
		head_x= r.nextInt(20)*40;
		head_y= r.nextInt(15)*40;
	}
	
	/**
	 * Redukcja ogonu weza
	 */
	public void ogony()
	{
		if(ogon.size()>punkty)
		{
			int i=0;
			while(ogon.size()!=punkty)
			{
				ogon.remove(i);
				i=i+1;
			}
		}	
	}

	/**
	 * Obsluga kolizji oraz przechodzenia przez sciany
	 */
	public void kolizja()
	{
			if(head_x>799)
			{
				head_x = 0;
			}
			else if(head_x<0)
			{
				head_x = 760;
			}
			else if(head_y>599)
			{
				head_y = 0;
			}
			else if(head_y<0)
			{
				head_y = 560;
			}


			it = ogon.iterator();

			while (it.hasNext()) {
				ogon_old = it.next();

			    if((head_x==ogon_old.x)&&(head_y==ogon_old.y))
			    {
			    	gra = false;
			    }
			}

	}

	/**
	 * Poruszanie sie weza
	 */
	public void polozenie()
	{
			if((head_x%40==0)&&(head_y%40==0)) {
			ogon.add(new kolejka(head_x,head_y,kierunek));	
			}
		
		
		switch(kierunek)
		{
		case 0: head_y = head_y + speed;

		break;

		case 1: head_y = head_y - speed;

		break;

		case 2: head_x = head_x - speed;

		break;

		case 3: head_x = head_x + speed;

		break;
		}

		ogony();

	}

	/**
	 * Sterowanie wezem
	 */
	public void input()
	{
		//System.out.println("head_x = "+this.head_x+"head_y"+this.head_y);
		int kierunek1 = 0;
		if(!ogon.isEmpty())
		{
			ogon_s = ogon.lastElement();
			kierunek1 = ogon_s.dir;
		}
		else
		{
			kierunek1 = kierunek;
		}

		if(Gdx.input.isKeyPressed(Keys.UP)&&(kierunek1!=1)&&(head_x%40==0))
		{
			kierunek = 0;
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN)&&(kierunek1!=0)&&(head_x%40==0))
		{
			kierunek = 1;

		}
		else if(Gdx.input.isKeyPressed(Keys.LEFT)&&(kierunek1!=3)&&(head_y%40==0))
		{
			kierunek = 2;

		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT)&&(kierunek1!=2)&&(head_y%40==0))
		{
			kierunek = 3;

		}
		else if(Gdx.input.isKeyPressed(Keys.SPACE))
		{
			punkty=punkty+1;

		}
		else if(Gdx.input.isKeyPressed(Keys.ESCAPE))
		{
			this.gra = false;
			this.poczatek = false;

		}

	}

	/**
	 * Generowanie jedzenia oraz sprawdzanie czy nastapilo zebranie jedzenia
	 */
	public void jedzenie()
	{
		if((head_x==applexy[0])&&(head_y==applexy[1]))
		{
			punkty = punkty+1;
			applexy[0] = r.nextInt(20)*40;
			applexy[1] = r.nextInt(15)*40;
			
			it = ogon.iterator();
			while (it.hasNext()) {
				ogon_old = it.next();
				
				if((applexy[0]==ogon_old.x) && (applexy[1]==ogon_old.y)) {
					applexy[0] = r.nextInt(20)*40;
					applexy[1] = r.nextInt(15)*40;
					it = ogon.iterator();
					//System.out.println("ogon_old.x = "+ogon_old.x);
					//System.out.println("ogon_old.y = "+ogon_old.y);
					//System.out.println("applexy[0] = "+applexy[0]);
					//System.out.println("applexy[1] = "+applexy[1]+"\n");
				}
			}
		}
	}

}
