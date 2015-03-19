package polymorphie;

public class B extends A {
	private int b;
	public B(int b){ this.b=b;}
	void p(int b) { 
		print("Beh!");
	}
	public int hurra(){ return this.b;}
}

