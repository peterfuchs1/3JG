package polymorphie;
public class C extends B {
	private int a;
	public C(int a){ this.a=a;}
	public String hurra(int a){return ""+super.hurra(a+5);}
}
