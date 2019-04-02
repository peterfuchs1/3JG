/**
 * 
 */
package dreiecke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dreiecke.*;
/**
 * @author uhs374h
 *
 */
public class TestDreiecksBerechnung {
	private SSS sss;
	private SSW ssw;
	private WSW wsw;
	private SWS sws;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sss=new SSS();
		ssw=new SSW();
		wsw=new WSW();
		sws=new SWS();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSSSFlaeche() {
		double a=3,b=5,c=7;
		double expected=6.49519;
		double actual=sss.getFlaeche(a, b, c);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSSSUmfang() {
		double a=3,b=5,c=7;
		double expected=15;
		double actual=sss.getUmfang(a, b, c);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSSSSatz() {
		String expected="SSS";
		String actual=sss.dreiecksSatz();
		assertEquals(expected, actual);
	}
	@Test
	public final void testSWSFlaeche() {
		double c=5.0, a=5.4, beta=0.8;
		double expected=9.6843;
		double actual=sws.getFlaeche(c, a, beta);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSWSUmfang() {
		double c=5.0, a=5.4, beta=0.8;
		double expected=14.46667;
		double actual=sws.getUmfang(c, a, beta);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSWSSatz() {
		String expected="SWS";
		String actual=sws.dreiecksSatz();
		assertEquals(expected, actual);
	}
	@Test
	public final void testWSWFlaeche() {
		double a=5.0, beta=0.8, gamma=1.1122;
		double expected=8.53291;
		double actual=wsw.getFlaeche(a, beta, gamma);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testWSWUmfang() {
		double a=5.0, beta=0.8, gamma=1.1122;
		double expected=13.56444;
		double actual=wsw.getUmfang(a, beta, gamma);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testWSWSatz() {
		String expected="WSW";
		String actual=wsw.dreiecksSatz();
		assertEquals(expected, actual);
	}
	@Test
	public final void testSSWFlaeche() {
		double b=4.0, c=5.0, beta=0.8;
		double expected=9.4227;
		double actual=ssw.getFlaeche(b, c, beta);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSSWUmfang() {
		double b=4.0, c=5.0, beta=0.8;
		double expected=14.25412;
		double actual=ssw.getUmfang(b, c, beta);
		assertEquals(expected, actual,0.001);
	}
	@Test
	public final void testSSWSatz() {
		String expected="SSW";
		String actual=ssw.dreiecksSatz();
		assertEquals(expected, actual);
	}

}
