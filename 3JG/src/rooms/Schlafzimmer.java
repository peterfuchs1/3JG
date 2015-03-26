package rooms;

/**
 * Berechnung:
 * Begehbarer Schrankraum: Verkehrsflaeche
 * verkehrsflaeche = schrankraum
 * nettoFlaeche = flaeche + schrankraum
 * beliebige Anzahl an Fenster >= 0
 * beliebige Anzahl an Tueren >= 0
 * 
 */
public class Schlafzimmer extends Wohnraum {

	public Schlafzimmer(double flaeche, double schrankraum, int tueren,
			int fenster) {
		super(flaeche+schrankraum, schrankraum, tueren, fenster);
		// Wird von der Superklasse behandelt
//		if (tueren < 0) throw new IllegalArgumentException("Anzahl der Tueren >= 0! ("+tueren+")");
//		if (fenster < 0) throw new IllegalArgumentException("Anzahl der Fenster >= 0! ("+fenster+")");
		this.schrankraum=schrankraum;
		this.betten = 0;
	}

	private int betten;

	/**
	 * Begehbarer Schrankraum: Verkehrsflaeche
	 * 
	 */
	private double schrankraum;
	
	/**
	 * @return the schrankraum
	 */
	public double getSchrankraum() {
		return schrankraum;
	}
	/**
	 * setter Schrankraum
	 * @throws IllegalArgumentException
	 * @param schrankraum the schrankraum to set
	 */
	public void setSchrankraum(double schrankraum) {
		if (schrankraum < 0) throw new IllegalArgumentException("Der Schrankraum muss >= 0 sein! ("+schrankraum+")");
		this.schrankraum = schrankraum;
	}
	/**
	 * setter betten
	 * @throws IllegalArgumentException
	 * @param betten
	 */
	public void setBetten(int betten) {
		if (betten < 0) throw new IllegalArgumentException("Anzahl der Betten >= 0! ("+betten+")");
		this.betten=betten;
	}
	/**
	 * getter Betten
	 * @return
	 */
	public int getBetten() {
		return this.betten;
	}

	/* (non-Javadoc)
	 * @see rooms.Rooms#getInformation()
	 */
	@Override
	public String getInformation() {
		String sf="";
		String st="";
		String ss="";
		if (this.anzahlFenster() > 0){
			sf= "\nmit " +this.anzahlFenster()+ " Fenster";
		}
		if (this.anzahlTueren() > 0)
			st="\nmit "+this.anzahlTueren()+" Tueren";
		if (this.schrankraum > 0){
			ss= "\nmit einem Schrankraum in der Groesse von " +this.schrankraum+ "m²";
		}
		String out=String.format("Ein Schlafzimmer mit %.2fm² Nettoflaeche und %.2fm² Nutzflaeche", this.nettoFlaeche(),this.nutzFlaeche());
		return out+sf+st+ss+".\n";
	}


}
