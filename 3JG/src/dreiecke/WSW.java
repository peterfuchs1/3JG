package dreiecke;

public class WSW implements DreiecksBerechnung {
	/**
	 * {@link DreiecksBerechnung#getFlaeche(double, double, double)}
	 */
	@Override
	public double getFlaeche(double a, double beta, double gamma) {
		double b=this.berechneSeite(a,beta,gamma);
		double c=this.berechneSeite(a,gamma,beta);
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	/**
	 * {@link DreiecksBerechnung#getUmfang(double, double, double)}
	 */
	@Override
	public double getUmfang(double a, double beta, double gamma) {
		double b=this.berechneSeite(a,beta,gamma);
		double c=this.berechneSeite(a,gamma,beta);
		return a+b+c;
	}
	/**
	 * Berechnet auf Basis des SSW-Satzes die fehlende Seite a
	 * 
	 * @param b
	 * @param c
	 * @param beta
	 * @return Seite a
	 */
	private double berechneSeite(double a, double beta, double gamma) {
		double alpha= Math.PI-beta-gamma;
		return a/Math.sin(alpha)*Math.sin(beta);
		
	}
	/**
	 * {@link DreiecksBerechnung#dreiecksSatz()}
	 */
	@Override
	public String dreiecksSatz() {
		return "WSW";
	}
}
