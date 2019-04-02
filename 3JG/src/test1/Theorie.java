package test1;

import java.awt.Point;

import javax.swing.JOptionPane;

public class Theorie {

	public static void main(String[] args) {
		// Bsp 5
		String part, str = JOptionPane.showInputDialog("Bitte etwas eingeben");
		System.out.println(str.substring(1, 4));
		// Bsp 6
		float y;
		str = JOptionPane.showInputDialog("y=");
		try {
			y = Float.parseFloat(str);
		} catch (NumberFormatException e) {y=0;}
		System.out.println("Hälfte der Eingabe: " + (y / 2));
		// Bsp 8 Identitaet
		Point p = new Point( 10, 10 );
		Point q = p;
		Point r = new Point( 10, 10 );
		System.out.println( p == q );     // wahr, da p und q dasselbe Objekt referenzieren
		System.out.println( p == r );    // falsch, da p und r zwei verschiedene Punkt-Objekte
										// referenzieren, die zufällig dieselben Koordinaten haben
	}
}
