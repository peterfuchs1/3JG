package tgm.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RechteckTest {

	@Test
	void rechteckOhneBreiteHoeheSollteNichtsAusgeben() {
		assertEquals(null,tgm.Rechteck.erstelleRechteck(0, 0, '*'),
				"Rechteck 0x0 sollte keine Ausgabe erzeugen");
		
	}
	@Test
	@DisplayName ("Rechteck hoehe < 1 sollte keine Ausgabe ergeben")
	void rechteckOhneHoeheSollteNichtsAusgeben() {
		assertEquals("",tgm.Rechteck.erstelleRechteck(0, 2, '*'),
				"Rechteck 0x2 sollte keine Ausgabe erzeugen");
		
	}
	@Test
	void rechteckOhneBreiteSollteNichtsAusgeben() {
		assertEquals("",tgm.Rechteck.erstelleRechteck(2, 0, '*'),
				"Rechteck 2x0 sollte keine Ausgabe erzeugen");
		
	}

}
