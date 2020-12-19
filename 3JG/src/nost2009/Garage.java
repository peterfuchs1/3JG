package nost2009;

public class Garage extends Bauwerk {
	private int parkPlaetze;
	public Garage(String bezeichnung, float preis, int parkPlaetze) {
		super(bezeichnung, preis);
		this.parkPlaetze=parkPlaetze;
	}
	public int getParkPlaetze() {return this.parkPlaetze;}
	public String beschreibung() {
		return super.beschreibung()+
				", ParkPlaetze: "+this.parkPlaetze;
	}
}
