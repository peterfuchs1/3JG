package lgs;
/**
 * Ein Gleichungssystem benoetigt die gleiche Anzahl an Spalten und Zeilen<br>
 * Die Spalten sind die Koeefizienten der Variablen<br>
 * Die Zeilen entsprechen den Gleichungen<br>
 * z.b.: <b>3</b> Spalten und <b>3</b> Zeilen<br>
 * Achtung: Hier werden keine Ergebnisse beruecksichtigt!
 * <br> 
 * 2 4 7<br>
 * 2 5 8<br>
 * 3 6 9<br>
 * <br>
 * 
 * @author Walter Rafeiner-Magor
 *
 */
public class NoSquareException extends Exception {
	private static final long serialVersionUID = 8834044998910102747L;
	/**
	 * Standard Konstruktor
	 */
	public NoSquareException() {
		super();
	}
	/**
	 * Exception mit Ausgabe auf System.err
	 * @param message Fehlermeldung
	 */
	public NoSquareException(String message) {
		super(message);
	}

}
