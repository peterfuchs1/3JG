package praxis1;

public abstract class SonstigeOperation implements Operation{
	private double zahl;
	public SonstigeOperation(double zahl) {
		this.zahl=zahl;
	}

	public double getZahl() {
		return this.zahl;
	}
}
