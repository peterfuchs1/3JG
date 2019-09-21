package test_bruch;
import bruch.Bruch;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Test5Bruch {
	private Bruch b;
	
	@BeforeEach
	public void setUp() throws Exception {
		b=new Bruch();
	}

	@AfterEach
	public void tearDown() throws Exception {
		b=null;
	}

	@Test
	@DisplayName("Test constructor: default constructor")
	public final void testConstructorBruch() {
		assertEquals(b.quotient(),0.0,0.01);
	}
	
	@Test
	@DisplayName("Test constructor: constructor with zaehler")
	public final void testConstructorBruchInt() {
		int expected =4;
		Bruch b2=new Bruch(expected);
		int actual=b2.getZaehler();
		assertEquals(expected,actual);
	}

	
	@DisplayName("Test constructor: constructor with zaehler and nenner")
	@Test
	public final void testConstructorBruchIntInt() {
		int zaehler = 1;
		int nenner = 8;
		double expected =(double)zaehler/nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}
	@Test
	@DisplayName("Test constructor: constructor with nenner=0")
	public final void testConstructorBruchIntNenner0() {
		int zaehler = 1;
		int nenner = 0;
		assertThrows(ArithmeticException.class, ()->
				new Bruch(zaehler,nenner));
		
	}

	@Test
	@DisplayName("Test object method: setting Zaehler")
	public final void testSetZaehler() {
		int zaehler = 3;
		b.setZaehler(zaehler);
		double expected =(double)zaehler/b.getNenner();
		double actual=b.quotient();
		assertEquals(expected,actual,0.01);
		
	}

	@Test
	@DisplayName("Test object method: setting Nenner")
	public final void testSetNenner() {
		int nenner = 3;
		b.setNenner(nenner);
		double expected =(double)b.getZaehler()/nenner;
		double actual=b.quotient();
		assertEquals(expected,actual,0.01);
	}
	@Test
	@DisplayName("Test object method: setting Nenner=0")
	public final void testSetNenner0() {
		assertThrows(ArithmeticException.class,
				()->b.setNenner(0));
	}

	@Test
	@DisplayName("Test object method: get Zaehler")
	public final void testGetZaehler() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertEquals(zaehler, b2.getZaehler());
	}

	@Test
	@DisplayName("Test object method: get Nenner")
	public final void testGetNenner() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertEquals(nenner, b2.getNenner());

	}

	@Test
	@DisplayName("Test object method: calculating Quotient")
	public final void testQuotient() {
		int zaehler = 1;
		int nenner = 8;
		double expected =(double)zaehler/nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: toString method")
	public final void testToString() {
		int zaehler = 1;
		int nenner = 8;
		String expected =""+zaehler+"/"+nenner;
		Bruch b2=new Bruch(zaehler,nenner);
		String actual=b2.toString();
		assertEquals(expected,actual);
	}


	@Test
	@DisplayName("Test object method: add bruch ")
	public final void testAddBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner+(double)z2/n2;
		b2.add(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
		
	}

	@Test
	@DisplayName("Test object method: add int value")
	public final void testAddInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner+(double)z2;
		b2.add(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: subtract int ")
	public final void testSubInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner-(double)z2;
		b2.sub(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);

	}

	@Test
	@DisplayName("Test object method: multply int ")
	public final void testMultiInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler*z2/nenner;
		b2.multi(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: divide by int ")
	public final void testDivInt() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		double expected =(double)zaehler/nenner/z2;
		b2.div(z2);
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: devide by zero ")
	public final void testDivIntException() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 0;
		assertThrows(ArithmeticException.class, 
				()->b2.div(new Bruch(z2)));
	}

	@Test
	@DisplayName("Test object method: subtract bruch ")
	public final void testSubBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner-(double)z2/n2;
		b2.sub(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: multiply bruch ")
	public final void testMultiBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner*(double)z2/n2;
		b2.multi(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: divide by bruch ")
	public final void testDivBruch() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 6;
		int n2 = 16;
		double expected =(double)zaehler/nenner*(double)n2/z2;
		b2.div(new Bruch(z2,n2));
		double actual=b2.quotient();
		assertEquals(expected,actual,0.01);
	}

	@Test
	@DisplayName("Test object method: add bruch (with zaehler=0)")
	public final void testDivBruchException() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		int z2 = 0;
		int n2 = 16;
		assertThrows(ArithmeticException.class, 
				()->b2.div(new Bruch(z2,n2)));

	}

	@Test
	@DisplayName("Test static method: add bruch ")
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
	@DisplayName("Test static method: subtract bruch ")
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
	@DisplayName("Test static method: multiply bruch ")
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
	@DisplayName("Test object method: equals bruch is true")
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
	@DisplayName("Test object method: equals bruch is false")
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
	@DisplayName("Test object method: equals bruch is not null")
	public final void testEqualsNull() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertFalse(b2.equals(null));
	}

	@Test
	@DisplayName("Test object method: equals identical bruch ")
	public final void testEqualsIdentical() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertTrue(b2.equals(b2));
	}

	@Test
	@DisplayName("Test object method: equals with wrong class type")
	public final void testEqualsWrongClass() {
		int zaehler = 1;
		int nenner = 8;
		Bruch b2=new Bruch(zaehler,nenner);
		assertFalse(b2.equals(new Object()));
	}

	@Test
	@DisplayName("Test object method: equals with wrong nenner ")
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
	@DisplayName("Test object method: equals with wrong zaehler ")
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
	@DisplayName("Test object method: compare to lower bruch")
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
	@DisplayName("Test object method: compare to greather bruch")
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
	@DisplayName("Test object method: compare to equal bruch")
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
	@DisplayName("Test object method: change sign")
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
