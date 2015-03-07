package zusicherung;

public class Rechteck extends GeomFigur {
	private int a;
	private int b;
	
	public Rechteck() {
		this(2);
	}
	public Rechteck(int a) {
		this(a,a);
	}
	/**
	 * @param a
	 * @param b
	 */
	public Rechteck(int a, int b) {
		if( a < 2 || b < 2)
			throw new IllegalArgumentException("Jede Seite muss größer als 1 sein!");
		this.a = a;
		this.b = b;
	}


	@Override
	public void anzeigen() {
		printHorizontal(a);
		printVertikal(a, b);
		printHorizontal(a);
		System.out.println();
	}


	private void printHorizontal(int len){
		for(int i=0;i<len;i++){
			System.out.print("*");
		}
		System.out.println();
	}
	
	private void printVertikal(int lenght, int height){
		for(int i=0;i<height-2;i++){
			System.out.print("*");
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<lenght-2;j++)
				sb.append(" ");
			System.out.print(sb.toString());
			System.out.println("*");
		}
	}
	
	public static void main(String args[]) {
		int max=4;
		int i=max-1;
		GeomFigur g[]=new GeomFigur[max];

		g[i--]= new Rechteck(1);
		g[i--]= new Rechteck();
		g[i--]= new Rechteck(3,10);
		g[i]= new Rechteck(5,3);
		
		for(;i<max;i++)
			g[i].anzeigen();
	}
	
}
