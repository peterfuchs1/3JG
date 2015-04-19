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
	@Mock private Verkehrsflaeche vk;
/**
 * Some work todo ...
 */
	public TestPolymorphieBmocking(){
		
		MockitoAnnotations.initMocks(this);
		when(vk.nettoFlaeche()).thenReturn(12.4);
		when(vk.anzahlFenster()).thenReturn(1);
		when(vk.anzahlTueren()).thenReturn(1);
		when(vk.getInformation()).thenReturn("Eine Verkehrsflaeche mit 12.40m² Nettoflaeche\nmit 1 Fenster\nmit 1 Tueren\n");
		/*
		 * Some work todo ...
		 */

		Rooms[] r=new Rooms[3];
		int i=r.length-1;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 3);
		r[i--]=new Schlafzimmer(18.2, 4.2, 1, 1);
//		r[i]=new Verkehrsflaeche(12.4, 1, 1);
		r[i] = vk;
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestPolymorphieBmocking();
		}
/* AUSGABE:
Eine Verkehrsflaeche mit 12.40m²
mit 1 Fenster
mit 1 Tuer.
Ein Schlafzimmer mit 22,40m² Nettoflaeche und 18,20m² Nutzflaeche
mit 1 Fenster
mit 1 Tueren
mit einem Schrankraum in der Groesse von 4.2m².
Ein Wohnzimmer mit 35,20m² Nettoflaeche und 35,20m² Nutzflaeche
mit 3 Fenster
mit 2 Tueren.
---------------------------------------
In Summe sind folgende Daten vorhanden:
Nettogesamtflaeche: 70,00m²
Nutzflaeche gesamt: 53,40m²
Anzahl aller Fenster: 5
Anzahl aller Tueren: 4
*/
}
