package rooms;

/**
 * Berechnung:
 * Nutzflaeche: (flaeche - verkehrsflaeche) >= 0
 * nettoFlaeche: flaeche	> 0
 * beliebige Anzahl an Fenster (>= 0)
 * beliebige Anzahl an Tueren (>= 0)
 * 
 */
public abstract class Wohnraum implements Rooms {

	private double flaeche;
	private double verkehrsFlaeche;
	private int tueren;
	private int fenster;

	/**
	 * Konstruktor mit allen Attributen
	 * @param flaeche
	 * @param verkehrsFlaeche
	 * @param tueren
	 * @param fenster
	 */
	public Wohnraum(double flaeche, double verkehrsFlaeche, int tueren,
			int fenster) {
		this.setFlaeche(flaeche);
		this.setVerkehrsFlaeche(verkehrsFlaeche);
		this.setFenster(fenster);
		this.setTueren(tueren);
	}

	/**
	 * Konstruktor mit Nettoflaeche und Verkehrsflaeche 
	 * @param flaeche
	 * @param verkehrsFlaeche
	 */
	public Wohnraum(double flaeche, double verkehrsFlaeche) {
		this(flaeche, verkehrsFlaeche, 0, 0);
	}

	/**
	 * Konstruktor nur mit Flaechenangabe
	 * @param flaeche
	 */
	public Wohnraum(double flaeche) {
		this(flaeche, 0.0);
	}

	@Override
	public double nettoFlaeche() {
		return flaeche;
	}

	@Override
	public double nutzFlaeche() {
		return flaeche-verkehrsFlaeche;
	}

	@Override
	public int anzahlFenster() {
		return fenster;
	}

	@Override
	public int anzahlTueren() {
		return tueren;
	}
	/**
	 * @throws IllegalArgumentException
	 * @param tueren the tueren to set
	 */
	public void setTueren(int tueren) {
		if (tueren <= 0) throw new IllegalArgumentException("Die Anzahl der Tueren muss >= 0 sein! ("+tueren+")");
		this.tueren = tueren;
	}

	/**
	 * @throws IllegalArgumentException
	 * @param fenster the fenster to set
	 */
	public void setFenster(int fenster) {
		if (fenster <= 0) throw new IllegalArgumentException("Die Anzahl der Fenster muss >= 0 sein! ("+fenster+")");
		this.fenster = fenster;
	}

	/**
	 * set flaeche
	 * @throws IllegalArgumentException
	 * @param flaeche
	 */
	public void setFlaeche(double flaeche) {
		if (flaeche <= 0) throw new IllegalArgumentException("Die Nettoflaeche muss > 0 sein! ("+flaeche+")");
		this.flaeche=flaeche;
	}
	/**
	 * setter verkehrsflaeche
	 * @throws IllegalArgumentException
	 * @param verkehrsFlaeche
	 */
	public void setVerkehrsFlaeche(double verkehrsFlaeche) {
		if (verkehrsFlaeche < 0 || (flaeche - verkehrsFlaeche) <= 0 ) 
			throw new IllegalArgumentException("Die Verkehrsflaeche muss >= 0 sein!\n"
					+ "sowie (flaeche - verkehrsflaeche) muss > 0sein ("+verkehrsFlaeche+")");
		this.verkehrsFlaeche = verkehrsFlaeche;
	}

	/* (non-Javadoc)
	 * @see rooms.Rooms#getInformation()
	 */
	@Override
	public String getInformation() {
		String sf="";
		String st="";
		if (this.fenster > 0){
			sf= "\nmit " +this.fenster+ "Fenster";
		}
		if (this.tueren > 0)
			st="\nmit "+this.tueren+" Tueren";
		String out=String.format("Ein allgemeiner Wohnraum mit %.2fm² Nettoflaeche und %.2fm² Nutzflaeche", this.nettoFlaeche(),this.nutzFlaeche());
		return out+sf+st+".\n";
	}

}
