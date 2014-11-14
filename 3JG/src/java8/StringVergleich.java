package java8;

public class StringVergleich {
	public static void main(String[] args){
		String r="Restart";
		String r2="restart";
		String r3="res";
		String r4="irgendwas";
		String r5=new String("Restart");
		System.out.println(r+"==\"Restart\":"+(r=="Restart"));
		System.out.println(r2+"==\"Restart\":"+(r=="Restart"));
		System.out.println(r2+".equals(\"Restart\"):"+(r2.equals("Restart")));
		System.out.println(r3+"==\"Restart\":"+(r3=="Restart"));
		System.out.println(r4+"==\"Restart\":"+(r4=="Restart"));
		System.out.println(r5+"==\"Restart\":"+(r5=="Restart"));
	}
}
