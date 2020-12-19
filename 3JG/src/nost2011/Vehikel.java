package nost2011;

public abstract class Vehikel {
	private float preis;
	private String bezeichnung;
	public Vehikel(String bezeichnung, float preis) {
		this.setBezeichnung(bezeichnung);
		this.setPreis(preis);
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung=bezeichnung;
	}
	public String getBezeichnung() {
		return this.bezeichnung;
	}
	public void setPreis(float preis) {
		this.preis=preis;
	}
	public float getPreis() { return this.preis;}
	public String beschreibung() {
		return "Bezeichnung: "+this.bezeichnung+", Preis: "+this.preis;
	}
}
