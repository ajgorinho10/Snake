package testy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import gra.kolejka;
import gra.waz;
/**
 * Testy jednostkowe weza
 */
public class wazTest{
	
	public JTextField tf;
	/**
	 * Test metody skracajacej ogon
	 */
	@Test
	public void ogonyTest() {
		waz w = new waz();
		w.punkty = 3;
		for(int i=0;i<5;i++) {
			w.ogon.add(new kolejka(10,10,10));
		}

		w.ogony();
		assertEquals(w.ogon.size(),w.punkty);
	}
	/**
	 * Test wykrywania kolizji
	 */
	@Test
	public void kolizjaTest() {
		waz w = new waz();
		w.head_x=40;
		w.head_y=40;
		w.ogon.add(new kolejka(40,40,1));
		w.kolizja();
		assertFalse(w.gra);
		
		w.head_x = 800;
		w.kolizja();
		assertEquals(w.head_x,0);

		w.head_y = 600;
		w.kolizja();
		assertEquals(w.head_x,0);
		
		w.head_x = -40;
		w.kolizja();
		assertEquals(w.head_x,760);
		
		w.head_y = -40;
		w.kolizja();
		assertEquals(w.head_y,560);
	}
	/**
	 * test metody polozenie z klasy waz
	 */
	@Test
	public void polozenieTest() {
		waz w = new waz();
		w.head_x = 40;
		w.head_y = 40;
		w.kierunek = 3;
		w.polozenie();
		w.polozenie();
		w.polozenie();
	
		w.kierunek = 0;
		w.polozenie();
		w.polozenie();
		w.polozenie();
		
		assertEquals(w.head_x,160);
		assertEquals(w.head_y,160);
	}
	/**
	 * test metody jedzenie z klasy waz
	 */
	@Test
	public void jedzenieTest() {
		waz w = new waz();

		assertTrue(w.applexy[0]%40==0);
		assertTrue(w.applexy[1]%40==0);
		
		w.head_x = w.applexy[0];
		w.head_y = w.applexy[1];
		
		w.jedzenie();
		assertEquals(w.punkty, 3);
		
		assertTrue(w.applexy[0]%40==0);
		assertTrue(w.applexy[1]%40==0);
	
	}
	
}















