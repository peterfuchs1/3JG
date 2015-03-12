package rooms;

/**
 * Berechnung:
 * nutzFlaeche = 0
 * nur Verkehrsflaeche
 * nettoFlaeche = flaeche
 * beliebige Anzahl an Fenster >= 0
 * beliebige Anzahl an Tueren >= 0
 * 
 */
public class Verkehrsflaeche implements Rooms {

	private double flaeche;

	private int tueren;

	private int fenster;

	public Verkehrsflaeche(double flaeche, int fenster, int tuere) {
		if (flaeche <= 0) throw new IllegalArgumentException("Die Nettoflaeche muss > 0 sein! ("+flaeche+")");
		if (tueren < 0) throw new IllegalArgumentException("Anzahl der Tueren >= 0! ("+tueren+")");
		if (fenster < 0) throw new IllegalArgumentException("Anzahl der Fenster >= 0! ("+fenster+")");
		this.flaeche=flaeche;
		this.fenster=fenster;
		this.tueren=tuere;
	}

	@Override
	public double nettoFlaeche() {
		return flaeche;
	}

	@Override
	public double nutzFlaeche() {
		return 0.0;
	}

	@Override
	public int anzahlFenster() {
		return fenster;
	}

	@Override
	public int anzahlTueren() {
		return tueren;
	}
	@Override
	public String getInformation() {
		String sf="";
		String st="";
		if (this.fenster > 0){
			sf= "\nmit " +this.fenster+ " Fenster";
		}
		if (this.tueren > 0)
			st="\nmit "+this.tueren+" Tueren";
		String out=String.format("Eine Verkehrsflaeche mit %.2fm² Nettoflaeche", this.nettoFlaeche());
		return out+sf+st+".\n";
	}
}
