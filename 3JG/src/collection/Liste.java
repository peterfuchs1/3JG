package collection;

import java.util.*;

public class Liste {
	private String[] anames= { "ASDF", "sdfg", "ASDF", "dfdfhg", "ASDF", "sdfg" };
	private List<String> names;
	
	public Liste() {
		List<String> lnames = Arrays.asList(anames);
		names = new LinkedList<>(lnames);
	}
	public static void main(String[] args) {
		Liste s= new Liste();
		System.out.println("Vor dem Remove:");
		s.print();
		System.out.println("---------------");
		s.remove("ASDF");
		System.out.println("Nach dem Remove");
		s.print();
	}
	public void print() {
		for(String name: names)
			System.out.println(name);
	}
	public void remove (String name) {
		for (String n : new ArrayList<String>(names)) {
			// Do something
			while (names.remove(name)) ;
		}		
	}
}
