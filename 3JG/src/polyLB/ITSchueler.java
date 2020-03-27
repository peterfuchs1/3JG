package polyLB;

public class ITSchueler extends Schueler {
	private String fach;
	public ITSchueler(String name, int alter, String jahrgang, String LieblingsFach) {
		super(name, alter, jahrgang);
		this.fach=LieblingsFach;
	}
	@Override
	public void daten(String d) {
		System.out.println("Aus ITSchueler("+d+", Lieblingsfach lautet: "+this.fach+")");
	}
}
