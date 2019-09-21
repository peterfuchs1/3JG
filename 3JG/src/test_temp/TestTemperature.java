package test_temp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestTemperature {
	private Temperature temp;
	@Before
	public void setUp() throws Exception {
		this.temp=new Temperature();
	}

	@After
	public void tearDown() throws Exception {
		this.temp=null;
	}

	@Test
	public void testTemperature() {
		assertEquals(0, temp.celsius(),0);
	}

	@Test
	public void testTemperatureDouble() {
		this.temp=new Temperature(3.4);
		assertEquals(3.4,temp.celsius(),0);
	}

	@Test
	public void testTemperatureDoubleCharC() {
		temp=new Temperature(3.4,'C');
		assertEquals(3.4,temp.celsius(),0);
	}

	@Test
	public void testTemperatureDoubleCharF() {
		temp=new Temperature(3.4,'F');
		assertEquals(3.4,temp.fahrenheit(),0.1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTemperatureDoubleCharException() {
		temp=new Temperature(3.4,'R');
		fail();
	}

	@Test
	public void testCelsius() {
		assertEquals(0, temp.celsius(),0);
	}

	@Test
	public void testFahrenheit() {
		temp=new Temperature(3.4,'C');
		double f=9 * (temp.celsius() / 5) + 32;
		assertEquals(f, temp.fahrenheit(),0.1);
	}

}
