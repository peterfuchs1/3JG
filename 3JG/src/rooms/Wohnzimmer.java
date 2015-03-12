package rooms;

/**
 * Berechnung:
 * Nutzflaeche= flaeche - verkehrsflaeche
 * nettoFlaeche = flaeche
 * beliebige Anzahl an Fenster >= 0
 * beliebige Anzahl an Tueren >= 0
 * 
 */
public class Wohnzimmer extends Wohnraum {

	private int sessel;
	private int tische;
	/**
	 * Konstruktor mit allen Attributen
	 * @param flaeche
	 * @param verkehrsFlaeche
	 * @param tueren
	 * @param fenster
	 */
	public Wohnzimmer(double flaeche, double verkehrsFlaeche, int tueren,
			int fenster) {
		super(flaeche, verkehrsFlaeche, tueren, fenster);
		if (tueren < 0) throw new IllegalArgumentException("Anzahl der Tueren >= 0! ("+tueren+")");
		if (fenster < 0) throw new IllegalArgumentException("Anzahl der Fenster >= 0! ("+fenster+")");
	}
	
	public void setSessel(int sessel) {
		this.sessel=sessel;
	}

	public int getSessel() {
		return sessel;
	}

	public void setTische(int tische) {
		this.tische=tische;
	}

	public int getTische() {
		return tische;
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
		String out=String.format("Ein Wohnzimmer mit %.2fm² Nettoflaeche und %.2fm² Nutzflaeche", this.nettoFlaeche(),this.nutzFlaeche());
		return out+sf+st+".\n";
	}

}

