/**
 * 
 */
package collection;

import java.util.List;
import java.util.Map;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public interface Lottery {
	/**
	 * Verlosung starten
	 */
	public void createLottery();
	/**
	 * Die Ziehung wird durchgeführt
	 */
	public void drawing();
	/**
	 * Los verkaufen
	 * @param verkauftes Los
	 */
	public void insertFortune(Fortune f);
	/**
	 * Los einlösen
	 * @param f
	 * @return Preis
	 */
	public String removeFortune(Fortune f);
	/**
	 * Liste aller verkauften Lose
	 * @return Liste von Losen
	 */
	public List<Fortune> availableFortunes();
	/**
	 * Liste aller Lose mit Gewinn
	 * @return Liste von Losen
	 */
	public Map<Fortune,String> winningFortunes();
	/**
	 * Gewinn des Loses
	 * @param Los
	 * @return konkreter Gewinn bzw "Leider kein Gewinn"
	 */
	public String fortuneWinningInformation(Fortune f);
	/**
	 * Ausgabe auf der Konsole: Alle Losnummern und deren Gewinn
	 */
	void printWinningFortunes();
	/**
	 * Ausgabe auf der Konsole: Alle verkauften Losnummern
	 */
	void printsoldFortunes();
	/**
	 * Verkaufe eine zufällige Anzahl von Losen zwischen Anzahl der Preise und 100
	 */
	void randomSoldFortunes();
}
