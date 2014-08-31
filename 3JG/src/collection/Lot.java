/**
 * 
 */
package collection;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class Lot {
	private static int lastNumber=0;
	private int number;
	private boolean sold;
	/**
	 * @param number
	 * @param sold
	 */
	private Lot() {
		this.number=++Lot.lastNumber;
		this.sold=false;
	}
	/**
	 * create a new Lot
	 * @return
	 */
	public static synchronized Lot getLot(){
		return new Lot();
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the sold
	 */
	public boolean isSold() {
		return sold;
	}
	/**
	 * @param sold the sold to set
	 */
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	/**
	 * @return the lastNumber
	 */
	public static int getLastNumber() {
		return lastNumber;
	}
	
	
}
