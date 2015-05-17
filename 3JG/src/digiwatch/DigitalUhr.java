package digiwatch;

import java.awt.Toolkit;
import java.time.ZonedDateTime;

public class DigitalUhr {
	private int minuten;
	private int stunden;
	private Zustand zustand;
	private int difToLocalTime;

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
		this.minuten = 0;
		this.stunden = 0;
		this.zustand = Zustand.ZeitAnzeigen;
		this.dostate();
		this.set();
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
			this.minuten+=value;
			this.minuten = (this.minuten  >= 0) ? this.minuten % 60 : 60+ this.minuten;
			break;
		case StundenEinstellen:
			this.stunden+=value;
			this.stunden = (this.stunden >= 0) ? this.stunden % 24 : 24+this.stunden;
			break;
		default:
			// keine neue Anzeige
			return;
		}
		this.dostate();
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
		this.change(1);
	}

	/**
	 * decrement
	 */
	public void dec() {
		this.change(-1);
	}

	/**
	 * make a piep
	 */
	public void piep() {
		Toolkit.getDefaultToolkit().beep();
	}

	public static String toDigits(int value) {
		return (value < 10) ? "0" + value : "" + value;
	}

	public void dostate() {
		ZonedDateTime lt = ZonedDateTime.now();
		int localMins=lt.getHour()*60+lt.getMinute();
		int actualMins=this.stunden*60+this.minuten;
		this.difToLocalTime=localMins-actualMins;
		System.out.print("\r" + toDigits(stunden) + ":" + toDigits(minuten)+" ->diff "+difToLocalTime);
	}

	/**
	 * @return the difToLocalTime
	 */
	public int getDifToLocalTime() {
		return difToLocalTime;
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
