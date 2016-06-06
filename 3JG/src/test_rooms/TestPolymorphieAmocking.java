/**
1.) Einfamilienhaus besteht aus:

    Wohnzimmer (35,2m², 2 Türen, 1 Fenster)
    Wohnzimmer (23m², 1 Türe, 3 Fenster)
    Schlafzimmer (18m², 1 Türe, 1 Fenster)
    Schlafzimmer (16,4m², 1 Türe, 2 Fenster)
    Schlafzimmer (17,5m², 2 Türen, 2 Fenster, Schrankraum 3,5m²)
    Bad (13,2m², 1 Fenster, 1 Türe, 2 Kaltwasser, 2 Warmwasseranschluss)
    Bad (15,5m², 1 Fenster, 1 Türe, 3 Kaltwasser, 2 Warmwasseranschluss)
    Vorraum = Verkehrsflaeche (8,8m², 5 Türen)
    Balkon (7,5m², Geländer=2,5m)

Mocking-Objekte für: Bad und Balkon
 */
package test_rooms;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rooms.*;
/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphieAmocking {
	@Mock private Balkon bk;
	@Mock private Bad b1,b2;


	public TestPolymorphieAmocking(){
		MockitoAnnotations.initMocks(this);
		//Bad1
		when(b1.anzahlFenster()).thenReturn(1);
		when(b1.anzahlTueren()).thenReturn(1);
		when(b1.nettoFlaeche()).thenReturn(13.2);
		when(b1.nutzFlaeche()).thenReturn(13.2);
		when(b1.getAnschluesse()).thenReturn(4);
		when(b1.getInformation())
		.thenReturn(
				"Ein Bad mit 13.2m², 1 Fenster, 1 Tür \n2 Kaltwasseranschluesse"
				+" und 2 Warmwasseranschlüsse");

		//Bad2
		when(b2.anzahlFenster()).thenReturn(1);
		when(b2.anzahlTueren()).thenReturn(1);
		when(b2.nettoFlaeche()).thenReturn(15.5);
		when(b2.nutzFlaeche()).thenReturn(15.5);
		when(b2.getAnschluesse()).thenReturn(5);
		when(b2.getInformation())
		.thenReturn(
				"Ein Bad mit 15.5m², 1 Fenster, 1 Tür \n3 Kaltwasseranschluesse"
				+" und 2 Warmwasseranschlüsse");
		
		//Balkon
		when(bk.nettoFlaeche()).thenReturn(7.5);
		when(bk.nutzFlaeche()).thenReturn(0.0);
		when(bk.getGelaender()).thenReturn(2.5);
		when(bk.getInformation())
		.thenReturn(
				"Ein Balkon mit 7.5m² und 2.50m langem Gelaender\n");
		Rooms[] r=new Rooms[9];
		int i=r.length-1;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 1);
		r[i--]=new Wohnzimmer(23.0, 0, 1, 3);
		r[i--]=new Schlafzimmer(18.0,0, 1, 1);
		r[i--]=new Schlafzimmer(16.4,0, 1, 2);
		r[i--]=new Schlafzimmer(17.5,3.5, 2, 2);
		r[i--]=b1;
		r[i--]=b2;
		r[i--]=new Verkehrsflaeche(8.8, 0, 5);
		r[i]=bk;
		
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
		System.out.printf("Nettogesamtflaeche: %.2fm²\nNutzflaeche gesamt: %.2fm²\n",s_nettof, s_nutzf);
		System.out.printf("Anzahl aller Fenster: %d\nAnzahl aller Tueren: %d\n",s_fenster, s_tueren);		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new TestPolymorphieAmocking();
		}
/**
Ausgabe:
Ein Balkon mit 7.5m² und 2.50m langem Gelaender

Eine Verkehrsflaeche mit 8,80m² Nettoflaeche
mit 5 Tueren.

Ein Bad mit 15.5m², 1 Fenster, 1 Tür 
3 Kaltwasseranschluesse und 2 Warmwasseranschlüsse
Ein Bad mit 13.2m², 1 Fenster, 1 Tür 
2 Kaltwasseranschluesse und 2 Warmwasseranschlüsse
Ein Schlafzimmer mit 21,00m² Nettoflaeche und 17,50m² Nutzflaeche
mit 2 Fenster
mit 2 Tueren
mit einem Schrankraum in der Groesse von 3.5m².

Ein Schlafzimmer mit 16,40m² Nettoflaeche und 16,40m² Nutzflaeche
mit 2 Fenster
mit 1 Tueren.

Ein Schlafzimmer mit 18,00m² Nettoflaeche und 18,00m² Nutzflaeche
mit 1 Fenster
mit 1 Tueren.

Ein Wohnzimmer mit 23,00m² Nettoflaeche und 23,00m² Nutzflaeche
mit 3 Fenster
mit 1 Tueren.

Ein Wohnzimmer mit 35,20m² Nettoflaeche und 35,20m² Nutzflaeche
mit 1 Fenster
mit 2 Tueren.

---------------------------------------
In Summe sind folgende Daten vorhanden:
Nettogesamtflaeche: 158,60m²
Nutzflaeche gesamt: 138,80m²
Anzahl aller Fenster: 11
Anzahl aller Tueren: 14 
*/
}
