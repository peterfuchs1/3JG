package test1;

public class Quadrat {
	private double seite;
	
	public Quadrat() {
		this(1);
	}
	
	public Quadrat(double seite) {
		if (Quadrat.istSeiteGueltig(seite))
			this.seite=seite;
		else
			this.seite=1;
	}
	
	public double flaeche() {
		return this.seite*this.seite;
	}
	
	public double umfang() {
		return this.seite*4;
	}
	
	public boolean vergroessern(double faktor) {
		double neueSeite=this.seite*faktor;
		boolean ret=false;
		if (Quadrat.istSeiteGueltig(neueSeite)) {
			this.seite=neueSeite;
			ret=true;
		}
		return ret;
	}
	public String text() {
		return "Quadrat: s="+this.seite+" cm, A="+this.flaeche()+" qcm, u="+this.umfang()+" cm";
	}
	public static boolean istSeiteGueltig(double seite) {
		boolean ret=false;
		if(seite>0 && seite <=1000000)
			ret=true;
		return ret;
	}
	
	public boolean istKleiner(Quadrat q) {
		boolean ret=false;
		if (this.flaeche()<q.flaeche())
			ret=true;
		return ret;
	}
	/**
	 * @return the seite
	 */
	public double getSeite() {
		return seite;
	}


	/**
	 * @param seite the seite to set
	 */
	public void setSeite(double seite) {
		this.seite = seite;
	}




}
