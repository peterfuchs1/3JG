package mock;

// CuT
import cut.Lottery;
// Imports für JUNIT Jupiter
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

// imports für Mockito
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Mock_Lottery {

	// Was soll "gemockt" werden?
	@Mock
	java.util.Random ri;

	// Wo werde ich die Mocks benötigen?
	@InjectMocks
	Lottery l;

	@BeforeEach
	void setupMock() {

//		when(ri.nextInt(45)).thenReturn(0,44,22,12,31,20);
	}

	// Nun kann ich damit testen
	@Test
	void testDraw() {
		when(ri.nextInt(45)).thenReturn(0,44,22,12,31,20);
		final int[] expected = { 1, 13, 21, 23, 32, 45 };
		int[] actual = l.draw(1, 45, 6);
		assertArrayEquals(expected, actual, "Found the right tip");
		verify(ri, times(6)).nextInt(45);
	}

	// Wie sieht es nun mit Exceptions aus?
	@Test
	void testNegativeIntegers() {
		when(ri.nextInt(-1)).thenThrow(new IllegalArgumentException());
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			ri.nextInt(-1);
		});
		verify(ri,times(1)).nextInt(-1);
	}

}
