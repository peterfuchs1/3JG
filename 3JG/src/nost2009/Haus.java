package nost2009;

public class Haus extends Bauwerk {

	private int zimmer;

	public Haus(String bezeichnung, float preis, int gaenge) {
		super(bezeichnung, preis);
		this.zimmer=gaenge;
	}

	public int getZimmer() {
		return this.zimmer;
	}

	public String beschreibung() {
		return super.beschreibung()+", Zimmer: "+this.zimmer;
	}

}
