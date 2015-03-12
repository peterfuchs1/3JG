package rooms;

/**
 * Berechnung:
 * nutzFlaeche= 0
 * nettoFlaeche = flaeche > 0
 * keine Fenster
 * keine Tueren
 * Gelaender > 0
 * 
 */
public class Balkon implements Rooms {

	/**
	 * @param flaeche
	 */
	public Balkon(double flaeche, double gelaender) {
		if (flaeche <= 0) throw new IllegalArgumentException("Die Nettoflaeche muss > 0 sein! ("+flaeche+")");
		if (gelaender <= 0) throw new IllegalArgumentException("Das Gelaender muss > 0 sein! ("+gelaender+")");
		this.flaeche = flaeche;
		this.gelaender=gelaender;
	}

	/**
	 * Laenge des Gelaenders 
	 * 
	 */
	private double gelaender;
	private double flaeche;

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
		return 0;
	}

	@Override
	public int anzahlTueren() {
		return 0;
	}
	@Override
	public String getInformation() {
		
		String out=String.format("Ein Balkon mit %.2fm² Nettoflaeche und einem %.2f langem Gelaender.\n", this.nettoFlaeche(),this.gelaender);
		return out;
	}
}
