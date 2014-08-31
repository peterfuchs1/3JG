/**
 * 
 */
package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Walter Rafeiner-Magor
 * 
 */
public class MakeLotteryDrawing implements Lottery {
	private ConcurrentHashMap<Lot, String> listLot;
	private static String noPrize = "Leider kein Gewinn";
	private boolean drawingDone;
	/**
	 * Erstellt eine neue Ziehung
	 */
	public MakeLotteryDrawing() {
		drawingDone = false;
	}

	@Override
	public void createLottery() {
		listLot = new ConcurrentHashMap<Lot, String>();
		drawingDone = false;
	}

	@Override
	public void randomSoldLots() {
		int LotsSold = (int) (Math.random() * 100.0 + 1);
		LotsSold = (LotsSold < Prizes.prizes.length) ? Prizes.prizes.length
				: LotsSold;
		for (int i = 0; i < LotsSold; i++) {
			Lot f = Lot.getLot();
			f.setSold(true);
			insertLot(f);
		}
	}

	@Override
	public synchronized void drawing() {
		if (!drawingDone) {
			// Verkaufte Lose holen
			Set<Lot> soldLots = listLot.keySet();
			// Liste der Preise erstellen
			LinkedList<String> prizes = new LinkedList<String>();
			for (int i = 0; i < Prizes.prizes.length; i++)
				prizes.add(Prizes.prizes[i]);
			// Preise den Losen zuordnen
			for (Lot f : soldLots) {
				// ersten Preis vergeben
				String actualPrize = prizes.remove(0);
				listLot.replace(f, noPrize, actualPrize);
				// Falls
				if (prizes.isEmpty())
					break;
			}
			drawingDone = true;
		}
	}

	@Override
	public void insertLot(Lot f) {
		listLot.put(f, noPrize);
	}

	@Override
	public String removeLot(Lot f) {
		return listLot.remove(f);
	}

	@Override
	public List<Lot> availableLots() {
		List<Lot> l = new LinkedList<Lot>();
		Iterator<Lot> i = listLot.keySet().iterator();
		while (i.hasNext())
			l.add(i.next());
		return l;
	}

	@Override
	public Map<Lot, String> winningLots() {
		HashMap<Lot, String> l = new HashMap<Lot, String>();
		Iterator<Lot> i = listLot.keySet().iterator();
		while (i.hasNext()) {
			Lot f = i.next();
			String prize = listLot.get(f);
			if (!prize.equals(noPrize))
				l.put(f, prize);
		}
		return l;
	}

	@Override
	public String LotWinningInformation(Lot f) {
		String prize = listLot.get(f);
		prize = (prize == null) ? "keinLos vorhanden" : prize;
		return prize;
	}

	@Override
	public void printWinningLots() {
		Iterator<Entry<Lot, String>> l = this.winningLots().entrySet()
				.iterator();
		while (l.hasNext()) {
			Entry<Lot, String> e = l.next();
			System.out.println("Los mit Nummer " + e.getKey().getNumber()
					+ " hat gewonnen: " + e.getValue());
		}
	}

	@Override
	public void printsoldLots() {
		Iterator<Lot> l = this.availableLots().iterator();
		while (l.hasNext()) {
			Lot f = l.next();
			System.out.println("Los mit Nummer " + f.getNumber()
					+ " wurde verkauft");
		}
	}

	/**
	 * @return the drawingDone
	 */
	public boolean isDrawingDone() {
		return drawingDone;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MakeLotteryDrawing lotto = new MakeLotteryDrawing();
		lotto.createLottery();
		lotto.randomSoldLots();
		lotto.drawing();
		lotto.printsoldLots();
		lotto.printWinningLots();

	}

}
