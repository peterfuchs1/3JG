/**
 * 
 */
package test_rooms;
import rooms.*;
/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Rooms[] r=new Rooms[6];
		int i=5;
		r[i--]=new Wohnzimmer(35.2, 0, 2, 3);
		r[i--]=new Schlafzimmer(18.2, 4.2, 1, 1);
		r[i--]=new Bad(12.4, 1, 1);
		r[i--]=new Balkon(8.8,3.5);
		r[i]=new Verkehrsflaeche(12.4, 1, 1);
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
