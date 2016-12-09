package collection;

import java.util.List;
import java.util.Map;
// Sefer
public class Test implements Lottery{

	@SuppressWarnings("unused")
	private int gln;

	public void createLottery() {
		gln = Lot.getLastNumber();
		
	}

	public void drawing() {
		Lot.getLot();
		
	}

	public void insertLot(Lot f) {
		// TODO Auto-generated method stub
		
	}

	public String removeLot(Lot f) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Lot> availableLots() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Lot, String> winningLots() {
		// TODO Auto-generated method stub
		return null;
	}

	public String LotWinningInformation(Lot f) {
		// TODO Auto-generated method stub
		return null;
	}

	public void printWinningLots() {
		// TODO Auto-generated method stub
		
	}

	public void printsoldLots() {
		// TODO Auto-generated method stub
		
	}

	public void randomSoldLots() {
		// TODO Auto-generated method stub
		
	}

}
