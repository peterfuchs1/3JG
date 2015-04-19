/**
 * 
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


	public TestPolymorphieAmocking(){
		MockitoAnnotations.initMocks(this);
		when(bk.anzahlFenster()).thenReturn(1);
		when(bk.anzahlTueren()).thenReturn(1);
		when(bk.nettoFlaeche()).thenReturn(8.8);
		when(bk.nutzFlaeche()).thenReturn(0.0);
		when(bk.getGelaender()).thenReturn(3.5);
		when(bk.getInformation())
				.thenReturn(
						"Ein Balkon mit 8.80m² und 3.50m langem Gelaender\n");
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
			new TestPolymorphieAmocking();
		}

}
