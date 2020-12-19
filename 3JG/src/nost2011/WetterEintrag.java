package nost2011;

public class WetterEintrag {
	private String datum;
	private float wert;

	public WetterEintrag(String datum, float wert) {
		this.datum=datum;
		this.wert=wert;
	}

	/**
	 * @return the datum
	 */
	public String getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(String datum) {
		this.datum = datum;
	}

	/**
	 * @return the wert
	 */
	public float getWert() {
		return wert;
	}

	/**
	 * @param wert the wert to set
	 */
	public void setWert(float wert) {
		this.wert = wert;
	}
	
}
