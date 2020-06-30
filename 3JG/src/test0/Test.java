package test0;

public class Test {


	public static void main(String[] args)
	{
		I1[] i1=new I1[3];
		I2[] i2=new I2[2];
//		i1[0]=new K1(); // DAmit kein Fehler angezeigt wird
//		i1[1]=new K3(); // DAmit kein Fehler angezeigt wird
		i1[2]=new K5();
		i2[1]=new K6();

		i1[1].m1();
		i2[1].m5('c', (byte)4);
//		i1[2].m6("wert", 234); // DAmit kein Fehler angezeigt wird
		
		

	}

}
