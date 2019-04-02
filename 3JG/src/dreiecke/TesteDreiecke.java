package dreiecke;

import java.util.HashMap;
import java.util.LinkedList;

public class TesteDreiecke {

	public static void main(String[] args) {
		LinkedList<HashMap<String,Double>> liste =new LinkedList<>();
		HashMap<String,Double> ds1=new HashMap<String,Double>();
		ds1.put("a",  3.0);ds1.put("b",  4.0);ds1.put("c",  5.0);
		liste.add(ds1);
		HashMap<String,Double> ds2=new HashMap<String,Double>();
		ds2.put("a",  3.0);ds2.put("wb",  4.0);ds2.put("c",  5.0);
		liste.add(ds2);
		HashMap<String,Double> ds3=new HashMap<String,Double>();
		ds3.put("a",  3.0);ds3.put("b",  4.0);ds3.put("wc",  5.0);
		liste.add(ds3);
		HashMap<String,Double> ds4=new HashMap<String,Double>();
		ds4.put("a",  1.0);ds4.put("b",  4.0);ds4.put("c",  5.0);
		liste.add(ds4);
		HashMap<String,Double> ds5=new HashMap<String,Double>();
		ds5.put("a",  3.0);ds5.put("wb",  4.0);ds5.put("b",  5.0);
		liste.add(ds5);
		HashMap<String,Double> ds6=new HashMap<String,Double>();
		ds6.put("wa",  3.0);ds6.put("wb",  4.0);ds6.put("wc",  5.0);
		liste.add(ds6);
		HashMap<String,Double> ds7=new HashMap<String,Double>();
		ds7.put("wa",  3.0);ds7.put("wb",  4.0);
		liste.add(ds7);
		for(HashMap<String,Double> h: liste) {
			System.out.println("Dreieck "+h.toString()+ "konstruierbar: "+Dreiecke.check(h));
			System.out.println("Dreieck "+h.toString()+ "konstruierbar: "+Dreiecke.checkText(h));		
		}

	}


}
