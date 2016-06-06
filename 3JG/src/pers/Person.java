package pers;

public class Person implements Comparable <Person>{

	
	private String vorname;
	private String nachname;

	/**
	 * @param vorname
	 * @param nachname
	 */
	public Person(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.vorname+" "+this.nachname;
	}



	@Override
	public int compareTo(Person p) {
		int ret;
		ret= this.nachname.compareTo(p.nachname);
		return(ret!=0)?ret:this.vorname.compareTo(p.vorname);
				
	}
	
	
}
