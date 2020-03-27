package regex;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testet die "Regex" Klasse
 * @author Gary Ye
 * @version 17-02-2013
 */
public class RegexTester {
	private Regex r;
	/**
	 * setUp Methode 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		r = new Regex(Regex.URL_REGEX);
	}
	/**
	 * tearDown Methode
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		r = null;
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch1() {
		assert(r.match("www.ibm.com")  == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch2(){
		assert(r.match("www. whitespace.com") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch3(){
		assert(r.match("www.cia.gov") == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch4(){
		assert(r.match("127.0.0.1") == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch5(){
		assert(r.match("notld") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch6(){
		assert(r.match("256.255.255.255") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch7(){
		assert(r.match("1024.0.0.1") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch8(){
		assert(r.match("8.8.8.8") == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch9(){
		assert(r.match("www.special&characters$are§bad.com") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch10(){
		assert(r.match("www.umlauteäöü.at") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch11(){
		assert(r.match("community.topcoder.com") == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch12(){
		assert(r.match("mustEndWith3Characters.abcd") == false);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch13(){
		assert(r.match("www.mit.edu") == true);
	}
	/**
	 * Test method for {@link YE.Regex#match()}
	 */
	@Test public void testMatch14(){
		assert(r.match("www..com") == false);
	}
	@Test
	public void match1() {
		r.addString("192.168.256.1");
		assertFalse(r.match());
	}
	@Test
	public void match2() {
		r.addString("192.168.255.1");
		assertTrue(r.match());
	}
	@Test
	public void match3() {
		this.r.addString("www.p-m-a.at");
		assertTrue(r.match());
	}
}
