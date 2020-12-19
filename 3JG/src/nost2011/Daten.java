package nost2011;

import java.util.ArrayList;
import java.util.List;

public class Daten<T> {

	private List<T> zeichen;

	public void speichern(T t) {
		zeichen.add(t);
	}

	public Daten() {
			zeichen=new ArrayList<>();
	}
	public T anzeigen(int i) {
		if(i>=0 && i<zeichen.size())
			return zeichen.get(i);
		else
			return null;
	}

	public static void main(String[] args) {
		Daten<String> d= new Daten<String>();
		d.speichern("Mein");
		d.speichern("Zwei");
		System.out.println(d.anzeigen(1));
		
		// Daten<> y = new Daten<Double>(); // Fehler!
		
		Daten<Double> x = new Daten<>();
		x.speichern(5.7);
		double du = x.anzeigen(0);
		System.out.println(du);

		
	}
}
