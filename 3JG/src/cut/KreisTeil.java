/**
 * 
 */
package cut;

/**
 * @author uhs374h
 *
 */
public class KreisTeil {
	private double r;
	private double w;
	public KreisTeil() {
		this(1);
	}
	public KreisTeil(double r) throws IllegalArgumentException{
		this(r,360.0);
	}
	public KreisTeil(double r, double w) throws IllegalArgumentException{
		if(r<0||w<0) throw new 
			IllegalArgumentException("Radius uns Winkel müssen positiv sein!");
		this.r=r;
		this.w=w;
	}
	
	
	public double bogen() {
		return this.w/180.0*Math.PI;
	}
	
	public double flaeche() {
		return this.r*this.r*Math.PI*w/360.0;
	}
	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}
	/**
	 * @return the w
	 */
	public double getW() {
		return w;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(double w) {
		this.w = w;
	}
	
}
