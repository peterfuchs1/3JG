package praxis1;

public class Addition extends BinaereOperation {

	public Addition(double a, double b) {
		super(a,b);
	}
	@Override
	public double ergebnis() {
		return this.getA()+this.getB();
	}
	@Override
	public String rechnenText() {
		return ""+this.getA()+"+"+this.getB()+"="+ergebnis();
	}

}
