package polymorphie;
public class C extends B {
	private int a;
	public C(int a){	
		super(a+2);
		this.a=a;
	}
	String hurra(int a){return ""+super.hurra(a++);}
	public int hurra() {return this.a*2;}
	void p(int b) {print("D");}
}
