package hashing;

public class Punkt implements Comparable<Punkt>{
	private int x; // coordinate x
	private int y; // coordinate y

	public Punkt(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString(){
		return "Punkt("+x+","+y+")";
	}
	@Override
	public int compareTo(Punkt p) {
		if( this==p || (this.x==p.x && this.y==p.y)) return 0;
		int dif = this.x-p.x;
		return dif != 0 ? dif: this.y-p.y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o != null) && (getClass() == o.getClass())) {
			Punkt p=(Punkt)o;
			return (this.x==p.x && this.y==p.y);
		}
		else
			return false;
	}
	
	
	@Override
	public int hashCode() {
		int hc = 31;
		int hm = 17;
		hc = hc * hm + x;
		hc = hc * hm + y;
		return hc;
	}
	
	private double vektor() {
		return Math.sqrt(x*x+y*y);
	}
}
