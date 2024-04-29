package testy;

import gra.ranking;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

import gra.rankObj;
/**
 * Testy jednostkowe rankingu
 */
public class rankingTest {
	/**
	 * Sprawdzenie dzailania metody aktualizowania rankingu
	 * @throws FileNotFoundException
	 */
	@Test
	 public void aktualizacjaTest() throws FileNotFoundException {
		
		ranking r = new ranking();
		rankObj g1 = new rankObj("Tomasz",100);
		rankObj g2;
		
		r.name = g1.nazwa;
		r.punkty = g1.punkty;
		r.ogon.push(g1);
		
		r.punkty=105;
		r.aktualizacja();
		g2 = r.ogon.peek();
		
		assertAll(
				"Aktualizacja",
				()->assertNotEquals(g1.punkty,g2.punkty),
				()->assertEquals(r.punkty,g2.punkty));
	}
	/**
	 * Sprawdzenie dzailania metody odczytowania rankingu z pliku
	 * @throws FileNotFoundException
	 */
	@Test
	public void odczytTest() throws FileNotFoundException {
		ranking r = new ranking();
		PrintWriter zapis = new PrintWriter("ranking.txt");
		
		for(int i=0;i<9;i++) {
			zapis.println("g"+(i+1)+" "+(i+1));
		}
        zapis.close();
		r.odczyt();
		
		for(int i=0;i<r.ogon.size();i++) {
			assertEquals(r.ogon.elementAt(i).nazwa,("g"+(i+1)));
			assertEquals(r.ogon.elementAt(i).punkty,(i+1));
		}
	}
	/**
	 * Sprawdzenie dzailania metody sortowania rankingu
	 * @throws FileNotFoundException
	 */
	@Test
	public void sortowanieTest() throws FileNotFoundException {
		ranking r = new ranking();
		r.odczyt();
		r.sortowanie();

		int j=r.ogon.size();
		for(int i=0;i<r.ogon.size();i++) {
			assertEquals(r.ogon.elementAt(i).nazwa,("g"+(j)));
			assertEquals(r.ogon.elementAt(i).punkty,(j));
			j-=1;
		}
	}
	/**
	 * Sprawdzenie dzailania metody zapisania rankingu do pliku
	 * @throws FileNotFoundException
	 */
	@Test
	public void zapisTest() throws FileNotFoundException {
		ranking r = new ranking();
		r.odczyt();
		r.sortowanie();
		r.zapis();
		r.odczyt();
		int j=r.ogon.size();
		for(int i=0;i<r.ogon.size();i++) {
			assertEquals(r.ogon.elementAt(i).nazwa,("g"+(j)));
			assertEquals(r.ogon.elementAt(i).punkty,(j));
			j-=1;
		}
	}

}
















