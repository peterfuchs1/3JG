package test_temp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Test5Temperature {
	private Temperature temp;
	@BeforeEach
	public void setUp() throws Exception {
		this.temp=new Temperature();
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.temp=null;
	}

	@Test
	@DisplayName("Test: Construtor default")
	public void testConstructorTemperature() {
		assertEquals(0, temp.celsius(),0);
	}

	@Test
	@DisplayName("Test: Construtor with double parameter")
	public void testConstructorTemperatureDouble() {
		this.temp=new Temperature(3.4);
		assertEquals(3.4,temp.celsius(),0);
	}

	@Test
	@DisplayName("Test: Construtor with double and char 'C' parameters")
	public void testConstructorTemperatureDoubleCharC() {
		temp=new Temperature(3.4,'C');
		assertEquals(3.4,temp.celsius(),0);
	}

	@Test
	@DisplayName("Test: Construtor with double and char 'F' parameters")
	public void testConstructorTemperatureDoubleCharF() {
		temp=new Temperature(3.4,'F');
		assertEquals(3.4,temp.fahrenheit(),0.1);
	}

	@Test
	@DisplayName("Test: Construtor with double and char 'R' parameters")
	public void testConstructorTemperatureDoubleCharException() {
		assertThrows(IllegalArgumentException.class,
				()->new Temperature(3.4,'R'));
	}

	@Test
	@DisplayName("Test: object method celsius")
	public void testObjectMethodCelsius() {
		assertEquals(0, temp.celsius(),0);
	}

	@Test
	@DisplayName("Test: object method fahrenheit")
	public void testObjectMethodFahrenheit() {
		temp=new Temperature(3.4,'C');
		double f=9 * (temp.celsius() / 5) + 32;
		assertEquals(f, temp.fahrenheit(),0.1);
	}
}
