package mitarbeiter;


public abstract class Mitarbeiter implements Zahlung{

	private String name;

	@Override
	public double zahlung() {
		return monatsBrutto();
	}

	private int alter;

	public Mitarbeiter() {
		this.setAlter(20);
		this.setName("NN");
	}

	/**
	 * @param name
	 * @param alter
	 */
	public Mitarbeiter(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	public abstract double monatsBrutto();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alter
	 */
	public int getAlter() {
		return alter;
	}

	/**
	 * @param alter the alter to set
	 */
	public void setAlter(int alter) {
		this.alter = alter;
	}



}
