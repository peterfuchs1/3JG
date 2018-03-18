package name;

public class Punkt implements Comparable<Punkt> {

	private int x;
	private int y;

	public Punkt(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public int compareTo(Punkt p) {
		if (x!=p.x) {
			return x-p.x;
		}
		else
			return y-p.y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Punkt("+x+","+y+")";
	}

}
