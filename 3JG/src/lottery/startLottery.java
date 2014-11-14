package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// Neppl
public class startLottery implements Lottery {
	ArrayList<Lot> al = new ArrayList<Lot>();
	int losnummer = (int)(Math.random());
	public static void main (String[] args) {
		
	}
	@Override
	public void createLottery() {
		for(int i=1; i<=100;i++){
			al.add(Lot.getLot());
		}
	}

	@Override
	public void drawing() {
		al.remove(losnummer);
	}

	@Override
	public void insertLot(Lot f) {
		
	}

	@Override
	public String removeLot(Lot f) {
		
		return null;
	}

	@Override
	public List<Lot> availableLots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Lot, String> winningLots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LotWinningInformation(Lot f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printWinningLots() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printsoldLots() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void randomSoldLots() {
		// TODO Auto-generated method stub
		
	}

}
