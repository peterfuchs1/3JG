package test_bruch;
import bruch.Bruch;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBruch {
	private Bruch b;
	@Before
	public void setUp() throws Exception {
		b=new Bruch();
	}

	@After
	public void tearDown() throws Exception {
		b=null;
	}

	@Test
	public final void testBruch() {
		assertEquals(b.quotient(),0.0,0);
	}

	@Test
	public final void testBruchInt() {
		int expected =4;
		Bruch b2=new Bruch(expected);
		int actual=b2.getZaehler();
		assertEquals(expected,actual);
	}

	@Test
	public final void testBruchIntInt() {
		int zaehler = 1;
		int nenner = 8;
		double expected =(double)zaehler/nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}
	@Test(expected=ArithmeticException.class)
	public final void testBruchIntNenner0() {
		int zaehler = 1;
		int nenner = 0;
		Bruch b2=new Bruch(zaehler,nenner);
		fail("Not reachable");
	}

	@Test
	public final void testSetZaehler() {
		int zaehler = 3;
		b.setZaehler(zaehler);
		double expected =(double)zaehler/b.getNenner();
		double actual=b.quotient();
		assertEquals(expected,actual,0);
		
	}

	@Test
	public final void testSetNenner() {
		int nenner = 3;
		b.setNenner(nenner);
		double expected =(double)b.getZaehler()/nenner;
		double actual=b.quotient();
		assertEquals(expected,actual,0);
	}
	@Test(expected=ArithmeticException.class)
	public final void testSetNenner0() {
		int nenner = 0;
		b.setNenner(nenner);
		fail("Not reachable");
	}

	@Test
	public final void testGetZaehler() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertEquals(zaehler, b2.getZaehler());
	}

	@Test
	public final void testGetNenner() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertEquals(nenner, b2.getNenner());

	}

	@Test
	public final void testQuotient() {
		int zaehler = 1;
		int nenner = 8;
		double expected =(double)zaehler/nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test
	public final void testToString() {
		int zaehler = 1;
		int nenner = 8;
		String expected =""+zaehler+"/"+nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		String actual=b2.toString();
		assertEquals(expected,actual);
	}


	@Test
	public final void testAddBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner+(double)z2/n2;
		b2.add(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
		
	}

	@Test
	public final void testAddInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner+(double)z2;
		b2.add(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test
	public final void testSubInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner-(double)z2;
		b2.sub(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);

	}

	@Test
	public final void testMultiInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler*z2/nenner;
		b2.multi(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test
	public final void testDivInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner/z2;
		b2.div(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test(expected=ArithmeticException.class)
	public final void testDivIntException() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 0;
		b2.div(new Bruch(z2));
		fail("Not reachable");
	}

	@Test
	public final void testSubBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner-(double)z2/n2;
		b2.sub(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test
	public final void testMultiBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner*(double)z2/n2;
		b2.multi(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test
	public final void testDivBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner*(double)n2/z2;
		b2.div(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0);
	}

	@Test(expected=ArithmeticException.class)
	public final void testDivBruchException() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 0;
		int n2 = 16;
		b2.div(new Bruch(z2,n2));
		fail("not reachable");
	}

	@Test
	public final void testAddBruchBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		Bruch b3=new Bruch(z2,n2);
		Bruch b4=Bruch.add(b2, b3);
		Bruch b5=new Bruch(1,2);
		assertEquals(b4,b5);
	}

	@Test
	public final void testSubBruchBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		Bruch b3=new Bruch(z2,n2);
		Bruch b4=Bruch.sub(b2, b3);
		Bruch b5=new Bruch(-1,4);
		assertEquals(b4,b5);

	}

	@Test
	public final void testMultiBruchBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		Bruch b3=new Bruch(z2,n2);
		Bruch b4=Bruch.multi(b2, b3);
		Bruch b5=new Bruch(3,64);
		assertEquals(b4,b5);
	}

	@Test
	public final void testEqualsTrue() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 2;
		int n2 = 16;
		Bruch b3=new Bruch(z2,n2);
		assertTrue(b2.equals(b3));
	}

	@Test
	public final void testEqualsFalse() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 3;
		int n2 = 16;
		Bruch b3=new Bruch(z2,n2);
		assertFalse(b2.equals(b3));
	}

	@Test
	public final void testEqualsNull() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertFalse(b2.equals(null));
	}

	@Test
	public final void testEqualsIdentical() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertTrue(b2.equals(b2));
	}

	@Test
	public final void testEqualsWrongClass() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertFalse(b2.equals(new Object()));
	}

	@Test
	public final void testEqualsWrongNenner() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 1;
		int n2 = 9;
		Bruch b3=new Bruch(z2,n2);
		assertFalse(b2.equals(b3));
	}

	@Test
	public final void testEqualsWrongZaehler() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 2;
		int n2 = 8;
		Bruch b3=new Bruch(z2,n2);
		assertFalse(b2.equals(b3));
	}
	@Test
	public final void testComparetoLower() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 2;
		int n2 = 8;
		Bruch b3=new Bruch(z2,n2);
		boolean expected=b2.compareTo(b3)<0;
		assertTrue(expected);
	}
	@Test
	public final void testComparetoGreather() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 2;
		int n2 = 8;
		Bruch b3=new Bruch(z2,n2);
		boolean expected=b3.compareTo(b2)>0;
		assertTrue(expected);
	}
	@Test
	public final void testComparetoEqual() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 1;
		int n2 = 8;
		Bruch b3=new Bruch(z2,n2);
		boolean expected=b3.compareTo(b2)==0;
		assertTrue(expected);
	}

	@Test
	public final void testVorzeichenwechsel() {
		int zaehler = -1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 1;
		int n2 = -8;
		Bruch b3=new Bruch(z2,n2);
		boolean expected=b3.compareTo(b2)==0;
		assertTrue(expected);
	}

	
}
