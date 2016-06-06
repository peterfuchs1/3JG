package hashing;

public class MyGolfball extends Golfball {
	private static final long serialVersionUID = 5296291971433883425L;
	public final static byte TwoPiece = 0;
	public final static byte ThreePiece = 1;
	private byte ballConstruction;

	public MyGolfball(String str, String mk, int comp, byte construction) {
		super(str, mk, comp);
		ballConstruction = construction;
	}

	public byte getConstruction() {
		return ballConstruction;
	}

	@Override
	public String toString() {
		return super.toString() + " " + ballConstruction;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			MyGolfball gb = (MyGolfball) obj; // Class equal, downcast.
			if (ballConstruction == gb.getConstruction())
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hc = super.hashCode();
		int hm = 17;
		hc = hc * hm + ballConstruction;
		return hc;
	}

	@Override
	public int compareTo(Object o) {
		return compareTo((MyGolfball) o);
	}

	public int compareTo(MyGolfball other) {
		int ret = super.compareTo(other);
		if (ret != 0)
			return ret;
		return (ballConstruction - other.getConstruction());
	}
}