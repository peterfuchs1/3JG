package dreiecke;

public class SSW implements DreiecksBerechnung {
	/**
	 * {@link DreiecksBerechnung#getFlaeche(double, double, double)}
	 */
	@Override
	public double getFlaeche(double b, double c, double beta) {
		double a=this.berechne(b,c,beta);
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	/**
	 * {@link DreiecksBerechnung#getUmfang(double, double, double)}
	 */
	@Override
	public double getUmfang(double b, double c, double beta) {
		double a=this.berechne(b,c,beta);
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
	private double berechne(double b, double c, double beta) {
		double gamma= Math.asin(Math.sin(beta)/b*c);
		double alpha= Math.PI-beta-gamma;
		return b/Math.sin(beta)*Math.sin(alpha);
		
	}
	/**
	 * {@link DreiecksBerechnung#dreiecksSatz()}
	 */
	@Override
	public String dreiecksSatz() {
		return "SSW";
	}
}
