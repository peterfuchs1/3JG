package rooms;

/**
 * Berechnung:
 * Nutzflaeche= flaeche - verkehrsflaeche > 0
 * nettoFlaeche = flaeche	> 0
 * beliebige Anzahl an Fenster
 * beliebige Anzahl an Tueren
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
		if (flaeche <= 0) throw new IllegalArgumentException("Die Nettoflaeche muss > 0 sein! ("+flaeche+")");
		if (verkehrsFlaeche < 0 || (flaeche - verkehrsFlaeche) < 0 ) 
			throw new IllegalArgumentException("Die Verkehrsflaeche muss >= 0 sein!\n"
					+ "sowie (flaeche - verkehrsflaeche) muss > 0sein ("+verkehrsFlaeche+")");
		
		this.flaeche = flaeche;
		this.verkehrsFlaeche = verkehrsFlaeche;
		this.tueren = tueren;
		this.fenster = fenster;
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
	 * setter flaeche
	 * @param flaeche
	 */
	public void setFlaeche(double flaeche) {
		this.flaeche=flaeche;
	}
	/**
	 * setter verkehrsflaeche
	 * @param verkehrsFlaeche
	 */
	public void setVerkehrsFlaeche(double verkehrsFlaeche) {
		this.verkehrsFlaeche=verkehrsFlaeche;
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
