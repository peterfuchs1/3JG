package nost2011;

public class Motorrad extends Vehikel {
	private int leistung;
	public Motorrad(String bezeichnung, float preis, int leistung) {
		super(bezeichnung, preis);
		this.leistung=leistung;
	}
	public int getParkPlaetze() {return this.leistung;}
	public String beschreibung() {
		return super.beschreibung()+
				", Leistung: "+this.leistung+" PS";
	}
}
