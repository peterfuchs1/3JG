package digiwatch;

import java.awt.Toolkit;

public class DigitalUhr {
	private int minuten;
	private int stunden;
	private Zustand zustand;

	/**
	 * @return the minuten
	 */
	public String getMinuten() {
		return toDigits(minuten);
	}

	/**
	 * @return the stunden
	 */
	public String getStunden() {
		return toDigits(stunden);
	}

	/**
	 * @return the zustand
	 */
	public Zustand getZustand() {
		return zustand;
	}

	public enum Zustand {
		ZeitAnzeigen, StundenEinstellen, MinutenEinstellen;
		public static Zustand next(Zustand z) {
			switch (z) {
			case ZeitAnzeigen:
				return StundenEinstellen;
			case StundenEinstellen:
				return MinutenEinstellen;
			default:
				return ZeitAnzeigen;
			}
		}
	}

	/**
	 * Konstruktor
	 */
	public DigitalUhr() {
		minuten = 0;
		stunden = 0;
		zustand = Zustand.ZeitAnzeigen;
		dostate();
		set();
	}

	/**
	 * internal routine for changing values the changing process depends on the
	 * state 'zustand'
	 * 
	 * @param value
	 */
	private void change(int value) {
		switch (zustand) {
		case MinutenEinstellen:
			minuten+=value;
			minuten = (minuten  >= 0) ? minuten % 60 : 60+ minuten;
			break;
		case StundenEinstellen:
			stunden+=value;
			stunden = (stunden >= 0) ? stunden % 24 : 24+stunden;
			break;
		default:
			// keine neue Anzeige
			return;
		}
		dostate();
	}

	/**
	 * change the state
	 */
	public void set() {
		zustand = Zustand.next(zustand);
		if (zustand != Zustand.ZeitAnzeigen)
			piep();
	}

	/**
	 * increment
	 */
	public void inc() {
		change(1);
	}

	/**
	 * decrement
	 */
	public void dec() {
		change(-1);
	}

	/**
	 * make a piep
	 */
	public void piep() {
		Toolkit.getDefaultToolkit().beep();
	}

	private static String toDigits(int value) {
		return (value < 10) ? "0" + value : "" + value;
	}

	public void dostate() {
		System.out.print("\r" + toDigits(stunden) + ":" + toDigits(minuten));
	}

	public static void main(String[] s) {
		DigitalUhr d1 = new DigitalUhr();
		d1.inc();
		d1.inc();
		d1.dec();
		d1.set();
		d1.dec();
		d1.dec();
		d1.set();
	}
}
