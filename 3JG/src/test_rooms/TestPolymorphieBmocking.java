/**
2. ) Wohnung besteht aus:

    Wohnzimmer (34,2m�, 2 T�ren, 1 Fenster)
    Schlafzimmer (18m�, 1 T�re, 1 Fenster)
    Schlafzimmer (17,5m�, 2 T�ren, 2 Fenster, Schrankraum 3,5m�)
    Bad (13,2m�, 1 Fenster, 1 T�re, 2 Kaltwasser, 2 Warmwasseranschluss)
    Vorraum = Verkehrsflaeche (5,8m�, 4 T�ren)
    Loggia = Balkon (7,5m�, Gel�nder=2,5m)

Mocking-Objekte f�r Schlafzimmer und Vorraum
 */
package test_rooms;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import rooms.*;
/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphieBmocking {
	@Mock private Schlafzimmer s1,s2;
	@Mock private Verkehrsflaeche vr;
/**
 * Some work todo ...
 */
	public TestPolymorphieBmocking(){
		
		MockitoAnnotations.initMocks(this);
		// Vorraum
		when(vr.nettoFlaeche()).thenReturn(5.8);
		when(vr.anzahlFenster()).thenReturn(0);
		when(vr.anzahlTueren()).thenReturn(4);
		when(vr.getInformation())
		.thenReturn(
				"Eine Verkehrsflaeche mit 5.80m� Nettoflaeche\nmit 4 Tueren\n");
		
		//Schlafzimmer1
		when(s1.anzahlFenster()).thenReturn(1);
		when(s1.anzahlTueren()).thenReturn(1);
		when(s1.nettoFlaeche()).thenReturn(18.0);
		when(s1.nutzFlaeche()).thenReturn(18.0);
		when(s1.getInformation())
		.thenReturn(
				"Ein Schlafzimmer mit 18.0m�, 1 Fenster, 1 T�r");
		//Schlafzimmer2
		when(s2.anzahlFenster()).thenReturn(1);
		when(s2.anzahlTueren()).thenReturn(1);
		when(s2.nettoFlaeche()).thenReturn(18.0);
		when(s2.nutzFlaeche()).thenReturn(18.0);
		when(s2.getSchrankraum()).thenReturn(3.5);
		when(s2.getInformation())
		.thenReturn(
				"Ein Schlafzimmer mit 17.5m�, 2 Fenster, 2 T�ren ein Schrankraum mit 3,5m�");


		
		
		Rooms[] r=new Rooms[6];
		int i=r.length-1;
		Bad b1=new Bad(13.2,1,1);
		b1.setKaltWasser(2);
		b1.setWarmWasser(2);
		r[i--]=new Wohnzimmer(34.2, 0, 2, 1);
		r[i--]=s1;
		r[i--]=s2;
		r[i--]=b1;
		r[i--]=vr;
		r[i]=new Balkon(7.5, 2.5);

		double s_nettof=0.0,s_nutzf=0.0;
		int s_fenster=0,s_tueren=0;
		for (;i< r.length;i++){
			s_nettof+=r[i].nettoFlaeche();
			s_nutzf+=r[i].nutzFlaeche();
			s_fenster+=r[i].anzahlFenster();
			s_tueren+=r[i].anzahlTueren();
			System.out.println(r[i].getInformation());
		}
		System.out.println("---------------------------------------");
		System.out.println("In Summe sind folgende Daten vorhanden:");
		System.out.printf("Nettogesamtflaeche: %.2fm�\nNutzflaeche gesamt: %.2fm�\n",s_nettof, s_nutzf);
		System.out.printf("Anzahl aller Fenster: %d\nAnzahl aller Tueren: %d\n",s_fenster, s_tueren);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestPolymorphieBmocking();
		}
/* AUSGABE:
Ein Balkon mit 7,50m� Nettoflaeche und einem 2,50m langem Gelaender.

Eine Verkehrsflaeche mit 5.80m� Nettoflaeche
mit 4 Tueren

Ein Badezimmer mit 13,20m� Nettoflaeche und 13,20m� Nutzflaeche
mit 1 Fenster
mit 1 Tueren
mit 2 Kaltwasser und
2 Warmwasserschluesse.

Ein Schlafzimmer mit 17.5m�, 2 Fenster, 2 T�ren ein Schrankraum mit 3,5m�
Ein Schlafzimmer mit 18.0m�, 1 Fenster, 1 T�r
Ein Wohnzimmer mit 34,20m� Nettoflaeche und 34,20m� Nutzflaeche
mit 1 Fenster
mit 2 Tueren.

---------------------------------------
In Summe sind folgende Daten vorhanden:
Nettogesamtflaeche: 96,70m�
Nutzflaeche gesamt: 83,40m�
Anzahl aller Fenster: 4
Anzahl aller Tueren: 9
*/
}
