/**
 * 
 */
package lgs;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface Determinante {
	/**
	 * Evaluiert das Gleichungssystem<br>
	 * 0 bedeutet: unendlich viele Loesungen<br>
	 * >0 bedeutet: loesbar<br>
	 * <0 bedeutet: keine Loesung vorhanden<br>
	 * @return 0 bzw. >0 oder <0
	 */
	public int evaluate();
}
