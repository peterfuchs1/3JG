/**
 * 
 */
package test_lgs;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lgs.IllegalDimensionException;
import lgs.LGS;
import lgs.MatrixException;
import lgs.NoSquareException;

/**
 * @author uhs374h
 *
 */
public class TestLGS {
	private double[][] matrixA={{2,4},{5,8}};
	private double[][] matrixB={{16},{34}} ;
	private double[][] loesung= {{2},{3}};
	LGS lgs=null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		lgs=new LGS(matrixA,matrixB);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		lgs=null;
	}

	/**
	 * Test method for {@link lgs.LGS#getMatrixA()}.
	 */
	@Test
	public final void testGetMatrixA() {
		double[][] expected=Arrays.copyOf(this.matrixA,matrixA.length);
		assertTrue(Arrays.deepEquals(lgs.getMatrixA(), expected));
	}

	/**
	 * Test method for {@link lgs.LGS#setMatrixA(double[][])}.
	 */
	@Test
	public final void testSetMatrixA() {
		double[][] expected=Arrays.copyOf(this.matrixA,matrixA.length);
		lgs.setMatrixA(expected);
		assertTrue(Arrays.deepEquals(lgs.getMatrixA(), expected));
		
	}

	/**
	 * Test method for {@link lgs.LGS#getMatrixB()}.
	 */
	@Test
	public final void testGetMatrixB() {
		double[][] expected=Arrays.copyOf(this.matrixB,matrixB.length);
		assertTrue(Arrays.deepEquals(expected, lgs.getMatrixB()));
	}

	/**
	 * Test method for {@link lgs.LGS#setMatrixB(double[][])}.
	 */
	@Test
	public final void testSetMatrixB() {
		double[][] expected=Arrays.copyOf(this.matrixB,matrixB.length);
		lgs.setMatrixA(expected);
		assertTrue(Arrays.deepEquals(lgs.getMatrixB(), expected));
	}

	/**
	 * Test method for {@link lgs.LGS#getMatrixE()}.
	 */
	@Test
	public final void testGetMatrixEBeforeSolve() {
		double[][] expected=Arrays.copyOf(lgs.getMatrixE(),lgs.getMatrixE().length);
		assertTrue(Arrays.deepEquals(lgs.getMatrixE(), expected));
	}

	/**
	 * Test method for {@link lgs.LGS#getMatrixE()}.
	 * @throws MatrixException 
	 */
	@Test
	public final void testGetMatrixEAfterSolve() throws MatrixException {
		lgs.solve();
		double[][] expected=loesung;
		assertTrue(Arrays.deepEquals(lgs.getMatrixE(), expected));
	}

	/**
	 * Test method for {@link lgs.LGS#LGS(double[][], double[][])}.
	 * @throws NoSquareException 
	 * @throws IllegalDimensionException 
	 */
	@Test
	public final void testLGS() throws IllegalDimensionException, NoSquareException {
		double[][] matrixa = {{2,4,7},{2,5,8},{3,6,9}};
		double[][] matrixb ={{20},{21},{24}};
		LGS lgs=new LGS(matrixa, matrixb);
		assertTrue(true);

	}
	/**
	 * Test method for {@link lgs.LGS#LGS(double[][], double[][])}.
	 * @throws NoSquareException 
	 * @throws IllegalDimensionException 
	 */
	@Test(expected=IllegalDimensionException.class)
	public final void testLGSIDE1() throws IllegalDimensionException, NoSquareException {
		double[][] matrixa = {{2,4,7},{2,5,8},{3,6,9}};
		double[][] matrixb ={{20},{21}};
		LGS lgs=new LGS(matrixa, matrixb);
		fail("not reachable");

	}
	/**
	 * Test method for {@link lgs.LGS#LGS(double[][], double[][])}.
	 * @throws NoSquareException 
	 * @throws IllegalDimensionException 
	 */
	@Test(expected=IllegalDimensionException.class)
	public final void testLGSIDE2() throws IllegalDimensionException, NoSquareException {
		double[][] matrixa = {{2,4,7},{2,5,8},{3,6,9}};
		double[][] matrixb ={{20,22},{21},{24}};
		LGS lgs=new LGS(matrixa, matrixb);
		fail("not reachable");

	}
	/**
	 * Test method for {@link lgs.LGS#LGS(double[][], double[][])}.
	 * @throws NoSquareException 
	 * @throws IllegalDimensionException 
	 */
	@Test(expected=IllegalDimensionException.class)
	public final void testLGSIDE3() throws IllegalDimensionException, NoSquareException {
		double[][] matrixa = {{2,4,7,8},{2,5,3,8},{2,1,5,8},{1,3,6,9}};
		double[][] matrixb ={{20},{21},{24}};
		LGS lgs=new LGS(matrixa, matrixb);
		fail("not reachable");

	}
	/**
	 * Test method for {@link lgs.LGS#LGS(double[][], double[][])}.
	 * @throws NoSquareException 
	 * @throws IllegalDimensionException 
	 */
	@Test(expected=NoSquareException.class)
	public final void testLGSIDE4() throws IllegalDimensionException, NoSquareException {
		double[][] matrixa = {{2,4,7,9},{2,5,8,7},{3,6,9,2}};
		double[][] matrixb ={{20},{21},{24}};
		LGS lgs=new LGS(matrixa, matrixb);
		fail("not reachable");

	}

	/**
	 * Test method for {@link lgs.LGS#solve()}.
	 * @throws MatrixException 
	 */
	@Test
	public final void testSolve() throws MatrixException {
		lgs.solve();
		double[][] expected=loesung;
		assertTrue(Arrays.deepEquals(lgs.getMatrixE(), expected));
	}

	/**
	 * Test method for {@link lgs.LGS#getNRows(double[][])}.
	 */
	@Test
	public final void testGetNRows() {
		int expected= this.matrixA.length;
		int actual=LGS.getNRows(matrixA);
		assertEquals(expected,actual);
	}

	/**
	 * Test method for {@link lgs.LGS#getNCols(double[][])}.
	 */
	@Test
	public final void testGetNCols() {
		int expected= this.matrixA[0].length;
		int actual=LGS.getNCols(matrixA);
		assertEquals(expected,actual);
	}



}
