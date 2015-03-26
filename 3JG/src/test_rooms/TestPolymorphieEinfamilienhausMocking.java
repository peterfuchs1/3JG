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
public class TestPolymorphieEinfamilienhausMocking {
	@Mock private Balkon bk;
	@Mock private Bad bad1;
	@Mock private Bad bad2;
	

	public TestPolymorphieEinfamilienhausMocking(){
		setupMocking();
		Rooms[] r=new Rooms[9];
		int i=r.length-1;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 1);
		r[i--]=new Wohnzimmer(23, 0, 1, 3);
		r[i--]=new Schlafzimmer (18,0, 1, 1);
		r[i--]=new Schlafzimmer (16.4,0, 1, 2);
		r[i--]=new Schlafzimmer (17.5,3.5, 2, 2);
		r[i--]=new Verkehrsflaeche(8.8, 0,5);
//		Bad (13,2m², 1 Fenster, 1 Türe, 2 Kaltwasser, 2 Warmwasseranschluss)
//		Bad bad1=new Bad(13.2,1,1);
//		bad1.setKaltWasser(2);
//		bad1.setWarmWasser(2);
		r[i--]=bad1;
//		Bad (15,5m², 1 Fenster, 1 Türe, 3 Kaltwasser, 2 Warmwasseranschluss)
//		Bad bad2=new Bad(15.5,1,1);
//		bad2.setKaltWasser(3);
//		bad2.setWarmWasser(2);		
		r[i--]=bad2;
//		Balkon (7,5m², Geländer=2,5m)
		Balkon bk=new Balkon(7.5, 2.5);
		r[i]=bk;
		
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
		System.out.printf("Nettogesamtflaeche: %.2fm²\nNutzflaeche gesamt: %.2fm²\n",s_nettof, s_nutzf);
		System.out.printf("Anzahl aller Fenster: %d\nAnzahl aller Tueren: %d\n",s_fenster, s_tueren);		
	}
	
	private void setupMocking(){
		MockitoAnnotations.initMocks(this);
		
//		Bad (13,2m², 1 Fenster, 1 Türe, 2 Kaltwasser, 2 Warmwasseranschluss)
		when(bad1.nettoFlaeche()).thenReturn(13.2);
		when(bad1.nutzFlaeche()).thenReturn(13.2);
		when(bad1.anzahlFenster()).thenReturn(1);
		when(bad1.anzahlTueren()).thenReturn(1);
		when(bad1.getInformation()).thenReturn("Ein Bad mit 13.2m² Nettoflaeche\nmit 1 Fenster\nmit 1 Tuere\nmit 2 Kaltwasser und\n2 Warmwasseranschluss\n");
		
//		Bad (15,5m², 1 Fenster, 1 Türe, 3 Kaltwasser, 2 Warmwasseranschluss)
		when(bad2.nettoFlaeche()).thenReturn(15.5);
		when(bad2.nutzFlaeche()).thenReturn(15.5);
		when(bad2.anzahlFenster()).thenReturn(1);
		when(bad2.anzahlTueren()).thenReturn(1);
		when(bad2.getInformation()).thenReturn("Ein Bad mit 15.5m² Nettoflaeche\nmit 1 Fenster\nmit 1 Tuere\nmit 3 Kaltwasser und\n2 Warmwasseranschluss\n");
		
//		Balkon (7,5m², Geländer=2,5m)
		when(bk.nettoFlaeche()).thenReturn(7.5);
		when(bk.getInformation()).thenReturn("Ein Balkon mit 7.5m² Nettoflaeche und einem 2.5m langem Gelaender.\n");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new TestPolymorphieEinfamilienhausMocking();
		}
/* AUSGABE:
Ein Balkon mit 7,50m² Nettoflaeche und einem 2,50m langem Gelaender.
Ein Badezimmer mit 15,50m² Nettoflaeche und 15,50m² Nutzflaeche
mit 1 Fenster
mit 1 Tueren
mit 3 Kaltwasser und
2 Warmwasserschluesse.
Ein Badezimmer mit 13,20m² Nettoflaeche und 13,20m² Nutzflaeche
mit 1 Fenster
mit 1 Tueren
mit 2 Kaltwasser und
2 Warmwasserschluesse.
Eine Verkehrsflaeche mit 8,80m² Nettoflaeche
mit 5 Tueren.
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

Mocking-Objekte für: Bad und Balkon

2. ) Wohnung besteht aus:

    Wohnzimmer (34,2m², 2 Türen, 1 Fenster)
    Schlafzimmer (18m², 1 Türe, 1 Fenster)
    Schlafzimmer (17,5m², 2 Türen, 2 Fenster, Schrankraum 3,5m²)
    Bad (13,2m², 1 Fenster, 1 Türe, 2 Kaltwasser, 2 Warmwasseranschluss)
    Vorraum = Verkehrsflaeche (5,8m², 4 Türen)
    Loggia = Balkon (7,5m², Geländer=2,5m)

*/
}
