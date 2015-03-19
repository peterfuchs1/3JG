package polymorphie;
public class D extends C {
	private int d;
	public D(int d){
		super(d-2);
	}
	String hurra(int a){
		return ""+super.hurra(a++);
	}
	public int hurra() {return this.d-2;}
	void p(int b){print("C");}
}
