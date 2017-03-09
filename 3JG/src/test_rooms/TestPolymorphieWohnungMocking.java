package test_rooms;

/**
 * Some work TODO
 */
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import rooms.*;


/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphieWohnungMocking {
	@Mock private Verkehrsflaeche vr;
	@Mock private Schlafzimmer sz1;
	@Mock private Schlafzimmer sz2;
	

	public TestPolymorphieWohnungMocking(){
		setupMocking();
		Rooms[] r=new Rooms[6];
		int i=r.length-1;
//		Wohnzimmer (34,2m�, 2 T�ren, 1 Fenster)
		r[i--]=new Wohnzimmer(34.2, 0, 2, 1);
//		Bad (13,2m�, 1 Fenster, 1 T�re, 2 Kaltwasser, 2 Warmwasseranschluss)
		Bad bad=new Bad(13.2, 1, 1);
		bad.setKaltWasser(2);
		bad.setWarmWasser(2);
		r[i--]=bad;
//	    Loggia = Balkon (7,5m�, Gel�nder=2,5m)	
		Balkon bk=new Balkon(7.5, 2.5);
		r[i--]=bk;
//		Schlafzimmer (18m�, 1 T�re, 1 Fenster)
//		Schlafzimmer sz1=new Schlafzimmer(18, 0, 1, 1);
		r[i--]=sz1;
//		Schlafzimmer (17,5m�, Schrankraum 3,5m�, 2 T�ren, 2 Fenster)
//		Schlafzimmer sz2=new Schlafzimmer(17.5, 3.5, 2, 2);
		r[i--]=sz2;
//		Vorraum = Verkehrsflaeche (5,8m�, 4 T�ren)
//		Verkehrsflaeche vr=new Verkehrsflaeche(5.8,0,4);
		r[i]=vr;
		
		double s_nettof=0.0,s_nutzf=0.0;
		int s_fenster=0,s_tueren=0;
		for (;i< r.length;i++){
			s_nettof+=r[i].nettoFlaeche();
			s_nutzf+=r[i].nutzFlaeche();
			s_fenster+=r[i].anzahlFenster();
			s_tueren+=r[i].anzahlTueren();
			System.out.print(r[i].getInformation());
		}
		System.out.println("---------------------------------------");
		System.out.println("In Summe sind folgende Daten vorhanden:");
		System.out.printf("Nettogesamtflaeche: %.2fm�\nNutzflaeche gesamt: %.2fm�\n",s_nettof, s_nutzf);
		System.out.printf("Anzahl aller Fenster: %d\nAnzahl aller Tueren: %d\n",s_fenster, s_tueren);		
	}
	
	private void setupMocking(){
		MockitoAnnotations.initMocks(this);
	    
//	    Schlafzimmer (18m�, 1 T�re, 1 Fenster)
		when(sz1.nettoFlaeche()).thenReturn(18.0);
		when(sz1.nutzFlaeche()).thenReturn(18.0);
		when(sz1.anzahlFenster()).thenReturn(1);
		when(sz1.anzahlTueren()).thenReturn(1);
		when(sz1.getInformation()).thenReturn("Ein Schlafzimmer mit 18.0m� Nettoflaeche\nmit 1 Fenster\nmit 1 Tuere\nmit 2 Kaltwasser und\n2 Warmwasseranschluss\n");
		
//	    Schlafzimmer (17,5m�, Schrankraum 3,5m�, 2 T�ren, 2 Fenster)
		when(sz2.nettoFlaeche()).thenReturn(17.5);
		when(sz2.nutzFlaeche()).thenReturn(17.5);
		when(sz2.getSchrankraum()).thenReturn(3.5);
		when(sz2.anzahlFenster()).thenReturn(2);
		when(sz2.anzahlTueren()).thenReturn(2);
		when(sz2.getInformation()).thenReturn(""
				+ "Ein Schlafzimmer mit 17.5m� Nettoflaeche\n"
				+ "mit einem Schrankraum mit 3.5m�\n"
				+ "mit 2 Fenster\nmit 2 Tuere\n"
				+ "mit 2 Kaltwasser und\n2 Warmwasseranschluss\n");
	    
//	    Vorraum = Verkehrsflaeche (5,8m�, 4 T�ren)
		when(vr.nettoFlaeche()).thenReturn(5.8);
		when(vr.anzahlTueren()).thenReturn(4);
		when(vr.getInformation()).thenReturn("Eine Verkehrsflaeche mit 5.8m� Nettoflaeche \nmit 4 Tueren.\n");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new TestPolymorphieWohnungMocking();
		}
/* AUSGABE:
Eine Verkehrsflaeche mit 5,80m� Nettoflaeche
mit 4 Tueren.
Ein Schlafzimmer mit 21,00m� Nettoflaeche und 17,50m� Nutzflaeche
mit 2 Fenster
mit 2 Tueren
mit einem Schrankraum in der Groesse von 3.5m�.
Ein Schlafzimmer mit 18,00m� Nettoflaeche und 18,00m� Nutzflaeche
mit 1 Fenster
mit 1 Tueren.
Ein Balkon mit 7,50m� Nettoflaeche und einem 2,50m langem Gelaender.
Ein Badezimmer mit 13,20m� Nettoflaeche und 13,20m� Nutzflaeche
mit 1 Fenster
mit 1 Tueren
mit 2 Kaltwasser und
2 Warmwasserschluesse.
Ein Wohnzimmer mit 34,20m� Nettoflaeche und 34,20m� Nutzflaeche
mit 1 Fenster
mit 2 Tueren.
---------------------------------------
In Summe sind folgende Daten vorhanden:
Nettogesamtflaeche: 99,70m�
Nutzflaeche gesamt: 82,90m�
Anzahl aller Fenster: 5
Anzahl aller Tueren: 10



*/
}
