package zusicherung;

public abstract class GeomFigur {
	private int x,y;
	private boolean sichtbar;
	public abstract void anzeigen();
	public void setPosition( int xNeu, int yNeu){
		x=xNeu;
		y=yNeu;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the sichtbar
	 */
	public boolean isSichtbar() {
		return sichtbar;
	}
	/**
	 * @param sichtbar the sichtbar to set
	 */
	public void setSichtbar(boolean sichtbar) {
		this.sichtbar = sichtbar;
	}
	
}
