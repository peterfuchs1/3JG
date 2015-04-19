/**
 * 
 */
package test_rooms;
import rooms.*;
/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphieA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Some work todo ...
		 * 
		 *  
		 *  
		 *  
		 */

		Rooms[] r=new Rooms[3];
		int i=r.length-1;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 3);
		r[i--]=new Bad(12.4, 1, 1);
		r[i]=new Balkon(8.8,3.5);
		
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

}
