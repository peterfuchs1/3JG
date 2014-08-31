package polymorphie;

public class A {
	static void print(String s) { System.out.println(s); }
	void p(char a) { print(""+'a'); }
	void p(int a)  { print("Aah!"); }	
}
