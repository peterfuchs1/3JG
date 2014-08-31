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
	 * ->Falls es noch keine neue Lottery gab!
	 */
	public void drawing();
	/**
	 * Los verkaufen
	 * @param verkauftes Los
	 */
	public void insertLot(Lot f);
	/**
	 * Los einlösen
	 * @param f
	 * @return Preis
	 */
	public String removeLot(Lot f);
	/**
	 * Liste aller verkauften Lose
	 * @return Liste von Losen
	 */
	public List<Lot> availableLots();
	/**
	 * Liste aller Lose mit Gewinn
	 * @return Liste von Losen
	 */
	public Map<Lot,String> winningLots();
	/**
	 * Gewinn des Loses
	 * @param Los
	 * @return konkreter Gewinn bzw "Leider kein Gewinn"
	 */
	public String LotWinningInformation(Lot f);
	/**
	 * Ausgabe auf der Konsole: Alle Losnummern und deren Gewinn
	 */
	void printWinningLots();
	/**
	 * Ausgabe auf der Konsole: Alle verkauften Losnummern
	 */
	void printsoldLots();
	/**
	 * Verkaufe eine zufällige Anzahl von Losen zwischen Anzahl der Preise und 100
	 */
	void randomSoldLots();
}
