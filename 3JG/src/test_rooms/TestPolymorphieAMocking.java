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
public class TestPolymorphieAMocking {
	@Mock private Balkon bk;
	

	public TestPolymorphieAMocking(){
/**
 * Some work todo
 */

		MockitoAnnotations.initMocks(this);
		when(bk.nettoFlaeche()).thenReturn(8.8);
		when(bk.getInformation()).thenReturn("Ein Balkon mit 8.8m² Nettoflaeche und einem 3.5m langem Gelaender.\n");
		Rooms[] r=new Rooms[3];
		int i=r.length-1;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 3);
		r[i--]=new Bad(12.4, 1, 1);
//		r[i]=new Balkon(8.8,3.5);
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			new TestPolymorphieAMocking();
		}
/* AUSGABE:
Ein Balkon mit 8.80m² und 3.50m langem Gelaender
Ein Badezimmer mit 12,40m² Nettoflaeche und 12,40m² Nutzflaeche
mit 1 Fenster
mit 1 Tueren.
Ein Wohnzimmer mit 35,20m² Nettoflaeche und 35,20m² Nutzflaeche
mit 3 Fenster
mit 2 Tueren.
---------------------------------------
In Summe sind folgende Daten vorhanden:
Nettogesamtflaeche: 56,40m²
Nutzflaeche gesamt: 47,60m²
Anzahl aller Fenster: 4
Anzahl aller Tueren: 3
*/
}
