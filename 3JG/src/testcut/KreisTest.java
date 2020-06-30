package testcut;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import cut.KreisTeil;

class KreisTest {
	private KreisTeil t;
	private static Logger log=Logger.getLogger("Mein Kreistest");
	
	@BeforeAll
	static void setUp() throws Exception {
		log.log(Level.INFO, "Test beginnt...");
	}
	
	@AfterAll
	static void closeDown() {
		log.log(Level.INFO, "Test ist beendet");
	}
	
	@Test
	@DisplayName("KreisTeil mit 2 Parametern, Radius=1 Winkel=360°")
	void testKreisTeilDoubleDouble() {
		log.log(Level.INFO,"Konstruktortest");
		t=new KreisTeil(1,360);
		double expected=Math.PI*2;
		double actual=t.bogen();
		assertEquals(expected, actual,0.01);
	}

	@Test
	@DisplayName("KreisTeil mit 2 Parametern, Radius=1 Winkel=45°")
	void testBogen() {
		log.log(Level.INFO,"Bogentest");
		t=new KreisTeil(1,45);
		double expected=Math.PI/4;
		double actual=t.bogen();
		assertEquals(expected, actual,0.01);
	}

	@Test
	@DisplayName("KreisTeil mit 2 Parametern, Radius=1 Winkel=180°")
	void testFlaeche() {
		log.log(Level.INFO,"Flaechentest");
		t=new KreisTeil(1,180);
		double expected=Math.PI/2;
		double actual=t.flaeche();
		assertEquals(expected, actual,0.01);
	}

}
