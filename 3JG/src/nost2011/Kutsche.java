package nost2011;

public class Kutsche extends Vehikel {

	private int pferde;

	public Kutsche(String bezeichnung, float preis, int pferde) {
		super(bezeichnung, preis);
		this.pferde=pferde;
	}

	public int getZimmer() {
		return this.pferde;
	}

	public String beschreibung() {
		return super.beschreibung()+", Pferde: "+this.pferde;
	}

}
