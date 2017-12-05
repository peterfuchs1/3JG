package polymorphie;
public interface A {
	public static void print(String s) { 				
		System.out.println(s); 
	}
	public default void p(int a)  { print(hurra(a));	}	
	public default String hurra(int a){ return ""+(++a);}
}

