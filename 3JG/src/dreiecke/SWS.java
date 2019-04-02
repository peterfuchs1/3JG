package dreiecke;

public class SWS implements DreiecksBerechnung {
	/**
	 * {@link DreiecksBerechnung#getFlaeche(double, double, double)}
	 */
	@Override
	public double getFlaeche(double c, double a, double beta) {
		double b=this.berechneSeite(c,a,beta);
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	/**
	 * {@link DreiecksBerechnung#getUmfang(double, double, double)}
	 */
	@Override
	public double getUmfang(double c, double a, double beta) {
		double b=this.berechneSeite(c,a,beta);
		return a+b+c;
	}
	/**
	 * Berechnet auf Basis des SWS-Satzes die fehlende Seite b
	 * Kosinussatz
	 * @param c
	 * @param a
	 * @param beta
	 * @return Seite b
	 */
	private double berechneSeite(double c, double a, double beta) {
		return Math.sqrt(a*a+c*c-2*a*c*Math.cos(beta));
		
	}
	/**
	 * {@link DreiecksBerechnung#dreiecksSatz()}
	 */
	@Override
	public String dreiecksSatz() {
		return "SWS";
	}
}
