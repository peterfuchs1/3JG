package assoziation;

public class Mitarbeiter {

	private double gehalt;

	public Mitarbeiter(double gehalt) {
		this.setGehalt(gehalt);
		this.gehalt = gehalt;
	}

	public double getGehalt() {
		return gehalt;
	}

	public void setGehalt(double gehalt) {
		if (gehalt <= 0) {
			throw new IllegalArgumentException("Das Gehalt muss groesser als 0 sein!");
		}
		this.gehalt = gehalt;
	}
}