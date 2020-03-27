package mitarbeiter;

public class Projekt implements Zahlung {

	private String name;

	private double kosten;

	public Projekt(String name, double kosten) {
		this.name=name;
		this.kosten=kosten;
	}

	public double zahlung() {
		return kosten;
	}


	/**
	 * @see mitarbeiter.Zahlung#name()
	 */
	public String name() {
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
