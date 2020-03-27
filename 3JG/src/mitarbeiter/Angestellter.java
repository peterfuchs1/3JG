package mitarbeiter;

public class Angestellter extends Mitarbeiter {

	private double gehalt;

	public Angestellter(String name, int alter, double gehalt) {
		super(name,alter);
		this.gehalt=gehalt;
	}

	public double monatsBrutto() {
		return gehalt*1.4;
	}

}
