package nost2007;

public class PKW extends Fahrzeug {
	private int leistung;
	public PKW(String bezeichnung, float preis, int leistung) {
		super(bezeichnung, preis);
		this.leistung=leistung;
	}
	public int getLeistung() {return this.leistung;}
	public String beschreibung() {
		return super.beschreibung()+
				", Leistung: "+this.leistung;
	}
}
