/**
 * 
 */
package blackbox;
import dreiecke.Dreiecke;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author uhs374h
 *
 */
public class DreieckeTesten {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckSSSOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("b",  4.0);d.put("c",  5.0);
		assertTrue(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckSWSOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("wb",  4.0);d.put("c",  5.0);
		assertTrue(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckSSWOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("b",  4.0);d.put("wc",  5.0);
		assertTrue(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckSSNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  1.0);d.put("b",  4.0);d.put("c",  5.0);
		assertFalse(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckSSWNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("wb",  4.0);d.put("b",  5.0);
		assertFalse(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckWWWNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);d.put("wc",  5.0);
		assertFalse(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckNotEnoughParameter2() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);
		assertFalse(Dreiecke.check(d));
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckNotEnoughParameter0() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		assertFalse(Dreiecke.check(d));
	}

	/**
	 * Test method for {@link dreiecke.Dreiecke#check(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckNotEnoughParameter4() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);d.put("a",  3.0);d.put("b",  4.0);
		assertFalse(Dreiecke.check(d));
	}


	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextSSSOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("b",  4.0);d.put("c",  5.0);
		String expected = "Ein Dreieck kann mit den Daten konstruiert werden";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextSWSOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("wb",  4.0);d.put("c",  5.0);
		String expected = "Ein Dreieck kann mit den Daten konstruiert werden";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextSSWOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("b",  4.0);d.put("wc",  5.0);
		String expected = "Ein Dreieck kann mit den Daten konstruiert werden";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextSSSNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  1.0);d.put("b",  4.0);d.put("c",  5.0);
		String expected = "Die Dreiecksungleichung ist nicht erfuellt";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextSSWNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("a",  3.0);d.put("wb",  4.0);d.put("b",  5.0);
		String expected = "Ein Dreieck ist mit den Daten nicht konstruierbar";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);	
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextWWWNOk() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);d.put("wc",  5.0);
		String expected = "Dreieck ist nicht eindeutig: 3 Winkel";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextNotEnoughParameter2() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);
		String expected = "Ein Dreieck benoetigt zur Konstruktion 3 Parameter ("+
		d.size()+" bekommen)";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}
	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextNotEnoughParameter0() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		String expected = "Ein Dreieck benoetigt zur Konstruktion 3 Parameter ("+
		d.size()+" bekommen)";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link dreiecke.Dreiecke#checkText(java.util.HashMap)}.
	 */
	@Test
	public final void testCheckTextNotEnoughParameter4() {
		HashMap<String,Double> d=new HashMap<String,Double>();
		d.put("wa",  3.0);d.put("wb",  4.0);d.put("a",  3.0);d.put("b",  4.0);
		String expected = "Ein Dreieck benoetigt zur Konstruktion 3 Parameter ("+
		d.size()+" bekommen)";
		String actual = Dreiecke.checkText(d); 
		assertEquals(expected,actual);
	}

}
