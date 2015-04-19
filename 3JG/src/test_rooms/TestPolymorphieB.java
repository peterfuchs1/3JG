/**
 * 
 */
package test_rooms;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rooms.*;
import static org.mockito.Mockito.*;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestPolymorphieB {

	@Mock
	private Verkehrsflaeche vk;
	private Rooms[] r;

	public TestPolymorphieB() {
		/*
		 * Some work todo ...
		 */
		MockitoAnnotations.initMocks(this);
		when(vk.anzahlFenster()).thenReturn(1);
		when(vk.anzahlTueren()).thenReturn(1);
		when(vk.nettoFlaeche()).thenReturn(12.4);
		when(vk.nutzFlaeche()).thenReturn(0.0);
		when(vk.getInformation())
				.thenReturn(
						"Eine Verkehrsflaeche mit 12.40m²\nmit 1 Fenster\nmit 1 Tuer.\n");
		r = new Rooms[3];
		int i = r.length - 1;
		r[i--] = new Wohnzimmer(35.2, 0, 2, 3);
		r[i--] = new Schlafzimmer(18.2, 4.2, 1, 1);
		r[i] = new Verkehrsflaeche(12.4, 1, 1);
		// r[i] = vk;
		double s_nettof = 0.0, s_nutzf = 0.0;
		int s_fenster = 0, s_tueren = 0;
		for (; i < r.length; i++) {
			s_nettof += r[i].nettoFlaeche();
			s_nutzf += r[i].nutzFlaeche();
			s_fenster += r[i].anzahlFenster();
			s_tueren += r[i].anzahlTueren();
			System.out.print(r[i].getInformation());
		}
		System.out.println("---------------------------------------");
		System.out.println("In Summe sind folgende Daten vorhanden:");
		System.out.printf(
				"Nettogesamtflaeche: %.2fm²\nNutzflaeche gesamt: %.2fm²\n",
				s_nettof, s_nutzf);
		System.out.printf(
				"Anzahl aller Fenster: %d\nAnzahl aller Tueren: %d\n",
				s_fenster, s_tueren);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestPolymorphieB();
	}
}
