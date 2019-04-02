/**
 * 
 */
package dreiecke;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface DreiecksBerechnung {
	/**
	 * Berechnet die Flaeche des Dreiecks<br>
	 * Die Berechnung ist abhaengig vom gewaehlten Satz<br>
	 * Die Winkel werden in Radiant erwartet!<br>
	 * <br>
	 * SSS: v1=Seite a, v2=Seite b, v3=Seite c<br>
	 * SSW: v1=erste Seite, v2=zweite Seite, v3=Winkel<br>
	 * WSW: v1=Seite, v2=erster Winkel, v2=zweiter Winkel<br>
	 * SWS: v1=erste Seite, v2=zweite Seite, v3=Winkel<br>
	 * @param v1 erster Parameter
	 * @param v2 zweiter Parameter
	 * @param v3 dritter Parameter
	 * @return Flaeche des Dreiecks
	 */
	public  double getFlaeche(double v1, double v2, double v3) ;
	/**
	 * Berechnet den Umfang des Dreiecks<br>
	 * Die Berechnung ist abhaengig vom gewaehlten Satz<br>
	 * Die Winkel werden in Radiant erwartet!<br>
	 * <br>
	 * SSS: v1=Seite a, v2=Seite b, v3=Seite c<br>
	 * SSW: v1=erste Seite, v2=zweite Seite, v3=Winkel<br>
	 * WSW: v1=Seite, v2=erster Winkel, v2=zweiter Winkel<br>
	 * SWS: v1=erste Seite, v2=zweite Seite, v3=Winkel<br>
	 * @param v1 erster Parameter
	 * @param v2 zweiter Parameter
	 * @param v3 dritter Parameter
	 * @return Umfang des Dreiecks
	 */
	public double getUmfang(double v1, double v2, double v3);
	/**
	 * Gibt den Satz zurueck, nachdem berechnet wird
	 * @return SSS oder SSW oder WSW oder SWS
	 */
	public String dreiecksSatz();
}
