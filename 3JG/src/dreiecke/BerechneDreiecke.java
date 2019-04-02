package dreiecke;

public class BerechneDreiecke {

	public static void main(String[] args) {
		final int dreiecke=4;
		DreiecksBerechnung[] d=new DreiecksBerechnung[dreiecke];
		double[][] p=new double[dreiecke][3];
		d[0]=new SSS();
		p[0][0]=3;p[0][1]=5;p[0][2]=7;
		d[1]=new SSW();
		p[1][0]=4;p[1][1]=5;p[1][2]=0.8;
		d[2]=new WSW();
		p[2][0]=5;p[2][1]=0.8;p[2][2]=1.1122;
		d[3]=new SWS();
		p[3][0]=5;p[3][1]=5.4;p[3][2]=0.8;
		for (int i=dreiecke-1;i>=0;--i) {
			System.out.println("Berechnung mittel "+d[i].dreiecksSatz());
			double v1=p[i][0];
			double v2=p[i][1];
			double v3=p[i][2];
			System.out.println("mit Parameter: "+v1+", "+v2+", "+v3);
			System.out.println("Fläche: "+d[i].getFlaeche(v1, v2, v3));
			System.out.println("Umfang beträgt: "+d[i].getUmfang(v1, v2, v3));
		}

	}

}
