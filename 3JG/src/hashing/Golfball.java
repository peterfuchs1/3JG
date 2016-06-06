package hashing;

import java.io.Serializable;

public class Golfball implements Serializable, Cloneable, Comparable<Object> {

	private static final long serialVersionUID = 409945942487184167L;
	private String brand;
	private String make;
	private int compression;

	public Golfball(String str, String mk, int comp) {
		brand = str;
		make = mk;
		compression = comp;
	}

	public String getBrand() {
		return brand;
	}

	public String getMake() {
		return make;
	}

	public int getCompression() {
		return compression;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if ((obj != null) && (getClass() == obj.getClass())) {
			Golfball gb = (Golfball) obj;
			if ((brand.equals(gb.getBrand())) && (make.equals(gb.getMake()))
					&& (compression == gb.getCompression())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hc = 31;
		int hm = 17;
		hc = hc * hm + brand.hashCode();
		hc = hc * hm + make.hashCode();
		hc = hc * hm + compression;
		return hc;
	}

	@Override public String toString(){
		return brand+" "+make+ " "+compression;
	}

	@Override
	public int compareTo(Object o) {
		return compareTo((Golfball) o);
	}

	public int compareTo(Golfball other) {
		if(this==other) return 0;
		if (other.getClass() != getClass())
		    throw new ClassCastException();
		// Vergleich brand
		int ret=(brand.compareTo(other.getBrand()));
		if (ret!=0) return ret;
		// Vergleich make
		ret=(make.compareTo(other.getMake()));
		if (ret!=0) return ret;
		// vergleich compression
		return (compression-other.getCompression());
	}
}