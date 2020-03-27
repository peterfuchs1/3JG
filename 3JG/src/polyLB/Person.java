package polyLB;

public class Person implements Printable {

	private String name;
	private int alter;
	public Person(String name, int alter) {
		this.name=name;
		this.alter=alter;
	}
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
	@Override
	public void daten() {
		System.out.print("Aus Person(Name: "+this.name+", Alter: "+this.alter+")");
		
	}
	@Override
	public void daten(String d) {
		System.out.println("Aus Person("+d+")");
	}
	
}
