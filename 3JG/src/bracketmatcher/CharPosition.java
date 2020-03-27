/**
 * 
 */
package bracketmatcher;

/**
 * @author uhs374h
 *
 */
public class CharPosition {
	private char c;
	private int pos;
	/**
	 * @param c
	 * @param pos
	 */
	public CharPosition(char c, int pos) {
		super();
		this.c = c;
		this.pos = pos;
	}
	/**
	 * @return the c
	 */
	public char getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(char c) {
		this.c = c;
	}
	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(int pos) {
		this.pos = pos;
	}
	
}
