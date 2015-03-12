package rooms;

/**
 * Fuer die Einreichung eines Bauvorhabens bei der Baupolizei (MA 37) - Wien müssen auch statistische Angaben zu einer Wohnung erstellt werden:
 * Gesamt-Nettoflaeche
 * Gesamt-Nutzflaeche
 * Anzahl der Tueren
 * Anzahl der Fenster
 */
public interface Rooms {

	/**
	 * Berechnung der Nettoflaeche: Gesamtflaeche
	 */
	public abstract double nettoFlaeche();

	/**
	 * Anzahl der vorhandenen Tueren je Raum
	 */
	public abstract int anzahlTueren();

	/**
	 * Anzahl der vorhandenen Fenster je Raum
	 */
	public abstract int anzahlFenster();

	/**
	 * Berechnung der Nutzflaeche: Nettoflaeche - Verkehrsflaechen
	 */
	public abstract double nutzFlaeche();
	/**
	 * Gibt eine druchbare Information des Raumes zurueck
	 */
	public abstract String getInformation();
}
