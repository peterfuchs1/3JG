package test_temp;

public class Temperature {
	public final static char[] UNITS = {'C','F'};
	private double t;
	public Temperature() {
		this(0.0);
	}
	/**
	 * Constructor for celsius
	 * @param t
	 */
	public Temperature(double t) {
		this(t,'C');
	}
	/**
	 * Constructor for all units
	 * @param t	temperature
	 * @param c	unit
	 * @throws IllegalArgumentException only 'C' for celsius 'F' for fahrenheit are allowed
	 */
	public Temperature(double t, char c) throws IllegalArgumentException{
		this.t=t;
		if(!correctUnit(c)) throw new IllegalArgumentException("Wrong Unit "+c+"!");
		if(c=='F') {
			this.t=fahrenheitToCelsius();
		}
	}
	/**
	 * Use only the allowed units!
	 * @param c unit
	 * @return true/false
	 */
	private boolean correctUnit(char c) {
		boolean ret=false;
		c=Character.toUpperCase(c);
		for(char element:Temperature.UNITS) {
			if (c==element) {
				ret=true;
				break;
			}
		}
		return ret;
	}
	/**
	 * convert our value to celsius unit
	 * @return value in celsius
	 */
	private double celsiusToFahrenheit() {
		return 9 * (this.t / 5) + 32;
	}
	/**
	 * convert our value to fahrenheit
	 * @return value in fahrenheit
	 */
	private double fahrenheitToCelsius() {
		return (this.t- 32) * 5 / 9;
	}
	/**
	 * our temperature in celsius unit
	 * @return
	 */
	public double celsius() {
		return this.t;
	}
	/**
	 * our temperature in fahrenheit unit
	 * @return
	 */
	public double fahrenheit() {
		return celsiusToFahrenheit();
	}
}
