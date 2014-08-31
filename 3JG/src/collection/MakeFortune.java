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
public class MakeFortune implements Lottery{
	private ConcurrentHashMap<Fortune,String> listFortune;
	private static String noPrize="Leider kein Gewinn";
	public MakeFortune(){
	}
	@Override
	public void createLottery(){
		listFortune=new ConcurrentHashMap<Fortune,String>();
	}
	@Override
	public void randomSoldFortunes(){
		int fortunesSold=(int)(Math.random()*100.0+1);
		fortunesSold=(fortunesSold<Prizes.prizes.length)?Prizes.prizes.length:fortunesSold;
		for (int i=0;i<fortunesSold;i++){
			Fortune f=Fortune.getFortune();
			f.setSold(true);
			insertFortune(f);
		}
	}
	@Override
	public synchronized void drawing(){
		Set<Fortune> soldFortunes=listFortune.keySet();
		LinkedList<String> prizes= new LinkedList<String>();
		for(int i=0;i<Prizes.prizes.length;i++)
				prizes.add(Prizes.prizes[i]);
		for(Fortune f:soldFortunes){
			String actualPrize=prizes.remove(0);
			listFortune.replace(f, noPrize, actualPrize);
			if(prizes.isEmpty()) break;	
		}
	}
	@Override
	public void insertFortune(Fortune f){
		listFortune.put(f, noPrize);
	}
	@Override
	public String removeFortune(Fortune f){
		return listFortune.remove(f);
		}
	@Override
	public List<Fortune> availableFortunes(){
		List<Fortune> l=new LinkedList<Fortune>();
		Iterator<Fortune> i=listFortune.keySet().iterator();
		while(i.hasNext())
			l.add(i.next());
		return l;
	}
	@Override
	public Map<Fortune,String> winningFortunes(){
		HashMap<Fortune,String> l=new HashMap<Fortune,String>();
		Iterator<Fortune> i=listFortune.keySet().iterator();
		while(i.hasNext()){
			Fortune f=i.next();
			String prize=listFortune.get(f);
			if(!prize.equals(noPrize))
				l.put(f,prize);
		}
		return l;
	}
	@Override
	public String fortuneWinningInformation(Fortune f){
		String prize=listFortune.get(f);
		prize=(prize==null)?"keinLos vorhanden":prize;
		return prize;
	}
	
	@Override
	public void printWinningFortunes(){
		Iterator<Entry<Fortune,String>> l=this.winningFortunes().entrySet().iterator();
		while(l.hasNext()){
			Entry<Fortune,String> e=l.next();
			System.out.println("Los mit Nummer "+e.getKey().getNumber()+" hat gewonnen: "+e.getValue());
		}
	}
	@Override
	public void printsoldFortunes(){
		Iterator<Fortune> l=this.availableFortunes().iterator();
		while(l.hasNext()){
			Fortune f=l.next();
			System.out.println("Los mit Nummer "+f.getNumber()+" wurde verkauft");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MakeFortune lotto= new MakeFortune();
		lotto.createLottery();
		lotto.randomSoldFortunes();
		lotto.drawing();
		lotto.printsoldFortunes();
		lotto.printWinningFortunes();
		

	}

}
