package assoziation;

import java.util.Arrays;

public class Sparpaket {

	private double nachlass;

	private Produkt[] inhalt;

	public Sparpaket(double nachlass, Produkt p) {

		if (p == null) {
			throw new IllegalArgumentException("Fuer p muss ein Wert angegeben werden!");
		}

		this.nachlass = nachlass;
		inhalt = new Produkt[1];
		inhalt[0] = p;

	}

	public void add(Produkt produkt) {
		inhalt=Arrays.copyOf(inhalt, inhalt.length+1);
		inhalt[inhalt.length - 1] = produkt;
	}
	
	public double gesamtPreis() {
		double sPreis=0.0;
		for(int i=0;i<inhalt.length;++i) {
			sPreis+=inhalt[i].getPreis();
		}
		return sPreis*(1-this.nachlass);
	}
}
