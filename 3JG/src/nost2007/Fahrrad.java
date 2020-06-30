package nost2007;

public class Fahrrad extends Fahrzeug {

	private int gaenge;

	public Fahrrad(String bezeichnung, float preis, int gaenge) {
		super(bezeichnung, preis);
		this.gaenge=gaenge;
	}

	public int getGaenge() {
		return this.gaenge;
	}

	public String beschreibung() {
		return super.beschreibung()+", Gaenge: "+this.gaenge;
	}

}
