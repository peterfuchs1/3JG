package dreiecke;

public class SSS implements DreiecksBerechnung {
	/**
	 * {@link DreiecksBerechnung#getFlaeche(double, double, double)}
	 */
	@Override
	public double getFlaeche(double a, double b, double c) {
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	/**
	 * {@link DreiecksBerechnung#getUmfang(double, double, double)}
	 */
	@Override
	public double getUmfang(double a, double b, double c) {
		return a+b+c;
	}
	/**
	 * {@link DreiecksBerechnung#dreiecksSatz()}
	 */
	@Override
	public String dreiecksSatz() {
		return "SSS";
	}

}
