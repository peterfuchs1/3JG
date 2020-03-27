package polyLB;

public class Schueler extends Person {

	private String jahrgang;

	public Schueler(String name, int alter, String jahrgang) {
		super(name, alter);
		this.jahrgang=jahrgang;
	}

	/**
	 * @return the jahrgang
	 */
	public String getJahrgang() {
		return jahrgang;
	}

	/**
	 * @param jahrgang the jahrgang to set
	 */
	public void setJahrgang(String jahrgang) {
		this.jahrgang = jahrgang;
	}

	@Override
	public void daten() {
		super.daten();
		System.out.println(", aus Schueler(Jahrgang: "+this.jahrgang+")");
	}

	
}
