package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Golfball> ll = new LinkedList<>();
		Golfball gb1 = new Golfball("gold", "nike", 4);
		ll.add(gb1);
		Golfball gb2 = new Golfball("gold", "nike", 4);
		ll.add(gb2);
		Golfball gb3 = new Golfball("gold", "nike", 6);
		ll.add(gb3);
		LinkedList<MyGolfball> llm = new LinkedList<>();
		MyGolfball mgb4 = new MyGolfball("silver", "wolf", 3, (byte) 1);
		llm.add(mgb4);
		MyGolfball mgb5 = new MyGolfball("silver", "wolf", 3, (byte) 1);
		llm.add(mgb5);
		MyGolfball mgb1 = new MyGolfball("gold", "nike", 4, (byte) 2);
		llm.add(mgb1);

		ArrayList<Golfball> al = new ArrayList<>();
		TreeSet<Golfball> ts = new TreeSet<>();
		HashSet<Golfball> hs = new HashSet<>();
		HashMap<Integer, Golfball> hm = new HashMap<>();
		int i = 0;

		ListIterator<MyGolfball> iterm = llm.listIterator();
		while (iterm.hasNext()) {
			MyGolfball gb = iterm.next();
			al.add(gb);
			ts.add(gb);
			hs.add(gb);
			hm.put(i++, gb);
		}

		ListIterator<Golfball> iter = ll.listIterator();
		while (iter.hasNext()) {
			Golfball gb = iter.next();
			al.add(gb);
//			ts.add(gb);	//ACHTUNG!!
			hs.add(gb);
			hm.put(i++, gb);
		}
		// ArrayList
		System.out.println("ArrayList- Start: ");
		for (Golfball gb : al) {
			System.out.println(gb.toString());
		}
		// TreeSet
		System.out.println("\nTreeSet - Start: ");
		for (Golfball gb : ts) {
			System.out.println(gb.toString());
		}
		// HashSet
		System.out.println("\nHashSet - Start: ");
		for (Golfball gb : hs) {
			System.out.println(gb.toString());
		}
		System.out.println("\nHashMap - Start: ");
		Set<Entry<Integer, Golfball>> s=hm.entrySet();
		Iterator<Entry<Integer,Golfball>> imap= s.iterator();
		while(imap.hasNext()){
			Entry<Integer,Golfball> e=imap.next();
			System.out.println("key: "+e.getKey()+", value: "+e.getValue().toString());
		}
	}

}
