package polyLB;

public class Main {

	public static void main(String[] args) {
		Printable[] p=new Printable[3];
		int i=p.length-1;
		p[i--] = new Person("Maier",18);
		p[i--] = new Schueler("Beier",19,"3CHIT");
		p[i] =new ITSchueler("Weber", 17, "3AHIT", "SEW");
		for (;i<p.length;++i) {
			p[i].daten("Just do IT");
			p[i].daten();
		}
	}

}
