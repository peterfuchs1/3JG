package lgs;
/**
 * Ein Gleichungssystem benoetigt für jede Spalte (x, y, z,....) <br>
 * einen Ergebniswert in Zeilen<br>
 * - Falls die Anzahl der Gleichungen (Zeilen) nicht <br>
 * mit der Anzahl der Ergebnisse uebereinstimmt<br>
 * - Falls die Anzahl der Koeffizienten der Variablen (Spalten) nicht <br>
 * mit der Anzahl der Ergebnisse uebereinstimmt<br>
 * - Falls die Anzahl der Ergebnisse fuer eine Gleichung  nicht <b>1</b> ist<br>
 * <br>
 * z.b.:<br>
 * x y z<br> 
 * 2 4 7 = <b>20</b><br>
 * 2 5 8 = <b>21</b><br>
 * 3 6 9 = <b>24</b><br>
 * <br>
 * @author Walter Rafeiner-Magor
 *
 */
public class IllegalDimensionException extends Exception {

	private static final long serialVersionUID = -7452581385148098883L;
	/**
	 * Standard Konstructor
	 */
	public IllegalDimensionException() {
		super();
	}
	/**
	 * Exception mit Ausgabe auf System.err
	 * @param message Fehlermeldung
	 */
	public IllegalDimensionException(String message) {
		super(message);
	}
}
