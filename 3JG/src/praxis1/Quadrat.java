package praxis1;

public class Quadrat extends SonstigeOperation {
	public Quadrat(double zahl) {
		super(zahl);
	}
	@Override
	public String rechnenText() {
		return ""+this.getZahl()+"^2="+this.ergebnis();
	}

	@Override
	public double ergebnis() {
		return this.getZahl()*this.getZahl();
	}

}
