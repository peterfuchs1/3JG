package tgm;

/**
 * Instanzen dieser Klasse enthalten den Vornamen, Nachnamen, Katalognummer und
 * die Gruppe eines Schülers
 * 
 * @author Walter Rafeiner-Magor
 * @version 19.03.2020
 */
public class Rechteck {

	/**
	 * Diese Methode gibt alle Noten als String zurück
	 * 
	 * @return den String mit allen Noten
	 */
	public static String erstelleRechteck(int hoehe, int breite, char c) {
		if (hoehe < 1 || breite < 1 || Character.isWhitespace(c))
			return null;
		StringBuilder s = new StringBuilder();
		// Obere Kante
		for (int i = 0; i < breite; ++i)
			s.append(c);
		// MittelTeil
			s.append(c); // linker Rand
			for(int i=0;i<breite-2; ++i)
					s.append(' ');
			if(breite >1) // Rechter Rand
				s.append(c);
		// Untere Kante
		for (int i = 0; i < breite; ++i)
			s.append(c);

		return s.toString();
	}
}
