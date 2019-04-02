package lgs;
/**
 * Nicht alle Gleichungssysteme sind auch l�sbar:<br>
 * Es kann keine oder unendlich viele L�sungen geben<br>
 *
 * @author uhs374h
 *
 */
public class MatrixException extends Exception {

	private static final long serialVersionUID = -8682675826403326612L;
	/**
	 * Exception mit Ausgabe auf System.err
	 * @param message Fehlermeldung
	 */
	public MatrixException(String message) {
		super(message);
		
	}
	/**
	 * Standard Konstruktor
	 */
	public MatrixException() {
		super();
		
	}

}
