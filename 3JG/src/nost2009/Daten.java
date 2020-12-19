package nost2009;

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
	public T erstes() {
		return zeichen.get(0);
	}

	public static void main(String[] args) {
		Daten<String> d= new Daten<String>();
		d.speichern("Mein");
		d.speichern("Zwei");
		System.out.println(d.erstes());
		
		Daten<Double> x = new Daten<>();
		x.speichern(5.7);
		double du = x.erstes();

		
	}
}
