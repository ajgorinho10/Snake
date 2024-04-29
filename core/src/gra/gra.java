package gra;


import java.io.FileNotFoundException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Glowna petla gry
 */
public class gra extends ApplicationAdapter {

	waz s; 
	rysowanie r; 
	ranking rank; 
	boolean raz = true;
	
	/**
	 * Utworzenie obiektow odpowiedzianych za obsluge weza , rankingu i wyswietlania
	 */
	@Override
	public void create () {
		r = new rysowanie();
		s = new waz();
		rank = new ranking();
		
		/*
		 * odczytujemy ranking z pliku tekstowego 
		 */
		try {
			rank.odczyt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Glowna petla gry
	 */
	@Override
	public void render ()
	{
		if(s.gra)
		{
			s.timeSeconds +=Gdx.graphics.getDeltaTime();
			if(s.timeSeconds > s.period)
			{
				s.timeSeconds-=s.period;

				s.polozenie();
				s.kolizja();
				s.jedzenie();
			}
			else
			{
				s.input();
				r.fps(s);
			}
		}
		else
		{
			try {
				r.ekrany(s,rank);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Zapisanie aplikacji przed wylaczeniem
	 */
	@Override
	public void dispose () {
		r.close();
		try {
			rank.zapis();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




















