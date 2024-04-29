package gra;

/**
 * Jednostka rankingu przechowywujaca nazwe oraz punkty
 */
public class rankObj implements Comparable<rankObj>{
	
	/**
	 * Nazwa gracza
	 */
	public String nazwa; 
	
	/**
	 * Punkty gracza
	 */
	public int punkty; 
	
	/**
	 * Konstruktor trojargumenty
	 * @param nazwa nazwa gracza
	 * @param punkty punkty gracza
	 */
	public rankObj(String nazwa,int punkty){
		this.nazwa = nazwa;
		this.punkty = punkty;
	}
	
	/**
	 * Konstruktor dwuargumenty
	 * @param nazwa nazwa gracza
	 */
	public rankObj(String nazwa){
		this.nazwa = nazwa;
		this.punkty = 0;
	}
	
	/**
	 * Metoda uzywana do posortowania rankingu
	 * @param o obiekt do porownania
	 * @return Roznica punktww podanych w argumencie funkcji od punktow dla danego gracza
	 */
	@Override
	 public int compareTo(rankObj o) {
	        return o.punkty - this.punkty;
	    }
}
