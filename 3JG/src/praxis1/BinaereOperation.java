package praxis1;

public abstract class BinaereOperation implements Operation{
	private double a;
	private double b;
	public BinaereOperation(double a, double b) {
		this.a=a;
		this.b=b;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}
	


}
