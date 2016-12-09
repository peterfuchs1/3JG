package lotto2;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	public final static int ANZAHL=6;			// Anzahl der gezogenen Werte
	public final static int MAX=45;				// Höchster gezogener Wert
	public final static int ERGEBNISSE=5;		// Gewinnmöglichkeiten (3er, 4er,...)
	private TreeSet<Integer> lottozahlen;
	private int zusatzzahl;
	/**
	 * 
	 */
	public Lotto() {
		lottozahlen=new TreeSet<Integer>();
		newTip();
		
	}
	
	public void newTip(){
		lottozahlen.clear();
		for (int i=0;i<ANZAHL;i++)
			lottozahlen.add(neueZahl(lottozahlen));
		zusatzzahl=neueZahl(lottozahlen);
	}
	
	public static TreeSet<Integer> autoTip(){
		TreeSet<Integer> ret=new TreeSet<Integer>();
		for (int i=0;i<ANZAHL;i++)
			ret.add(neueZahl(ret));
		return ret;
	}
	
	private static int neueZahl(Set<Integer> hs) {
		int ret=0;
		while(ret==0) {
			int a=(int)(Math.random()*MAX)+1;
			if (!hs.contains(a))
				ret=a;
		}
		return ret;
	}
	
	public int check(Set<Integer> tip){
		int ret=0;
		Iterator<Integer> i=tip.iterator();
		while (i.hasNext()) 
			if(lottozahlen.contains(i.next())) ret++;
		return ret;
	}

	public boolean checkZusatz(Set<Integer> tip){
		boolean ret=false;
		Iterator<Integer> i=tip.iterator();
		while (i.hasNext()&& !ret) 
			if(i.next()==zusatzzahl) ret=true;
		return ret;
	}
	
	public int[] toArray(){
		int[] ret=new int[ANZAHL];
		int i=0;
		Iterator<Integer> it=lottozahlen.iterator();
		while(it.hasNext())
			ret[i++]=it.next();
//		ret[i]=zusatzzahl;
		return ret;
	}
	@Override
	public String toString() {
		StringBuilder s=new StringBuilder();
		Iterator<Integer> i=lottozahlen.iterator();
		while (i.hasNext()){ 
			 s.append(i.next());
			 if(i.hasNext())
				 s.append(", ");
		}
		s.append(" ZZ: ");
		s.append(zusatzzahl);
		return s.toString();
	}
	
	public static String toString(Set<Integer> tip){
		StringBuilder sb=new StringBuilder();
		Iterator<Integer> it=tip.iterator();
		while (it.hasNext()){
			sb.append(it.next());
			if(it.hasNext())
				sb.append(", ");
		}
		return sb.toString();
	}
	@SuppressWarnings("unused")
	public static void main(String[] args){
		Lotto lotto=new Lotto();
		for (int schleife=0;schleife<3;schleife++){
			TreeSet<Integer> hs=Lotto.autoTip();
			Iterator<Integer> it=hs.iterator();
			System.out.println("Der Autotip lautet: "+Lotto.toString(hs));
			System.out.println("Die aktuellen Lottozahlen lauten: "+lotto.toString());
			System.out.println("Die Anzahl der richtigen Lottozahlen lautet: "+lotto.check(hs));
			String s=(lotto.checkZusatz(hs))?"richtig":"falsch";
			System.out.println("Die Zusatzzahl ist: "+s);
			System.out.println();
			lotto.newTip();
		}
	}
}
