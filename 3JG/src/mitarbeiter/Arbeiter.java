package mitarbeiter;

public class Arbeiter extends Mitarbeiter {

	private double gehalt;

	public Arbeiter(String name, int alter, double gehalt) {
		super(name,alter);
		this.gehalt=gehalt;
	}

	public double monatsBrutto() {
		return gehalt*1.2;
	}

}
