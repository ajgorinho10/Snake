package gra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Obsluga rankingu
 */
public class ranking {
	/**
	 * Nazwa gracza
	 */
	public String name;
	
	/**
	 * Punkty gracza
	 */
	public int punkty;
	
	/**
	 * Stos przechowywyjacy ranking
	 */
	public Stack<rankObj> ogon;
	
	/**
	 * Plik przechowywyujacy ranking
	 */
	public File rank;
	
	/**
	 * Iterator do przegladania stosu
	 */
	public Iterator<rankObj> it;
	
	/**
	 * Pojedynczy element rankingu czyli jeden gracz
	 */
	public rankObj element;
	
	/**
	 * Utworzenie stosu który przechowuje obiekty rankObj
	 * oraz otworzenie pliku zawierajacego ranking
	 */
	public ranking(){
		ogon = new Stack<rankObj>();
		rank = new File("ranking.txt");
		System.out.println(rank.getAbsolutePath());
		name ="";
		punkty = 0;
	}
	
	/**
	 * Odczytanie pliku tekstowego i zapisanie danych 
	 * w stosie ogon jako obiekty rankObj
	 * @throws FileNotFoundException obsluga wyjatku
	 */
	public void odczyt() throws FileNotFoundException{
		ogon = new Stack<>();
		Scanner odczyt = new Scanner(rank);
		int punkty = 0;
		String text = null;
		String punkty1 = "";
		String nazwa = "";
		int a=0;
		int i=0;
		int ile=0;
		while(odczyt.hasNext()&&ile<8)
		{
			ile++;
			text = odczyt.nextLine();
			i=0;
			for(i=0;i<text.length();i++)
			{
				if(i==0)
				{
					nazwa = "";
				}
				else
				{
					nazwa = nazwa + text.charAt(i-1);
				}
				if(text.charAt(i)==' ')
				{
					a=0;
					for(a=i;a<text.length();a++)
					{
						if(a==i)
						{
							punkty1 = "";
							punkty = text.charAt(a);
						}
						else
						{
							punkty1 = punkty1 + text.charAt(a);
						}
					}
					break;
				}
	
			}
			punkty = Integer.valueOf(punkty1);
			this.ogon.add(new rankObj(nazwa,punkty));	
	}
}
	/**
	 * Sortowanie rankingu	
	 */
	public void sortowanie(){
		Collections.sort(ogon);
	}
	
	/**
	 * Jesli danych gracz osiagnie rekord to
	 * nastepuje aktualicja rankingu dla niego
	 */
	public void aktualizacja() {
	
		rankObj x;
		int a=0;
		int b = 0;
		Iterator<rankObj> it = this.ogon.iterator();
		while(it.hasNext()){
			x = it.next();
			//System.out.println("r name = "+x.nazwa+" r p ="+x.punkty+" n name = "+this.name+" n punkty ="+this.punkty);
			if(x.nazwa.equals(this.name)){
				b+=1;
				if(x.punkty>this.punkty) {
					this.punkty = x.punkty;
				}
				//System.out.println("1");
				ogon.remove(a);
				ogon.push(new rankObj(this.name,this.punkty));
				break;
			}
			a+=1;
		}
		if(b==0) {
			ogon.push(new rankObj(this.name,this.punkty));
		}
		this.sortowanie();
	}
	
	/**
	 * Zapisanie rankingu przechowywanego w 
	 * polu ogon do pliku tekstowego
	 * @throws FileNotFoundException obslga wyjatku
	 */
	public void zapis() throws FileNotFoundException {
		System.out.print("zapis");
		this.punkty = this.punkty-2;
		sortowanie();
		PrintWriter zapis = new PrintWriter("ranking.txt");
		rankObj x;
		Iterator<rankObj> it = this.ogon.iterator();
		
		while(it.hasNext()){
			x = it.next();
			zapis.println(x.nazwa+" "+x.punkty);
		}
        zapis.close();
	}
	
	/**
	 * Funkcja testowa wyswietlajaca ranking w konsoli
	 */
	public void wyswietlenie() {
		rankObj x;
		Iterator<rankObj> it = this.ogon.iterator();
		while(it.hasNext()){
			x = it.next();
			System.out.println(x.nazwa+" "+x.punkty);
		}
	}
	
	
}

