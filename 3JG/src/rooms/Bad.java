package rooms;

/**
 * Berechnung:
 * Warm- und Kaltwasseranschluesse
 * nettoFlaeche = nutzFlaeche = flaeche
 * 1-2 Tueren
 * 1-2 Fenster
 * 
 * 
 */
public class Bad extends Wohnraum {

	public Bad(double flaeche, int tueren, int fenster) {
		super(flaeche, 0.0, tueren, fenster);
		if (tueren < 1 || tueren > 2) throw new IllegalArgumentException("Anzahl der Tueren 1 oder 2! ("+tueren+")");
		if (fenster < 1 || fenster > 2) throw new IllegalArgumentException("Anzahl der Fenster 1 oder 2! ("+fenster+")");
		this.warmWasser=0;
		this.kaltWasser=0;
	}

	/**
	 * Anzahl der Warmwasseranschluesse
	 */
	private int warmWasser;

	/**
	 * Anzahl der Kaltwasseranschluesse
	 */
	private int kaltWasser;

	public int getAnschluesse() {
		return warmWasser + kaltWasser;
	}

	/**
	 * Anzahl der Warmwasseranschluesse >= 0
	 */
	public void setWarmWasser(int anschluesse) {
		if (anschluesse < 0) throw new IllegalArgumentException("Anzahl der Warmwasseranschluesse >= 0! ("+anschluesse+")");
		this.warmWasser=anschluesse;
	}

	/**
	 * Anzahl der Kaltwasseranschluesse >= 0
	 */
	public void setKaltWasser(int anschluesse) {
		if (anschluesse < 0) throw new IllegalArgumentException("Anzahl der Kaltasseranschluesse >= 0! ("+anschluesse+")");
		this.kaltWasser=anschluesse;

	}
	/* (non-Javadoc)
	 * @see rooms.Rooms#getInformation()
	 */
	@Override
	public String getInformation() {
		String sf="";
		String st="";
		if (this.anzahlFenster() > 0){
			sf= "\nmit " +this.anzahlFenster()+ " Fenster";
		}
		if (this.anzahlTueren() > 0)
			st="\nmit "+this.anzahlTueren()+" Tueren";
		String out=String.format("Ein Badezimmer mit %.2fm² Nettoflaeche und %.2fm² Nutzflaeche", this.nettoFlaeche(),this.nutzFlaeche());
		return out+sf+st+".\n";
	}


}
