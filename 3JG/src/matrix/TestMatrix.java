/**
 * 
 */
package matrix;
/**
 * @author Walter Rafeiner-Magor
 *
 */
public class TestMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		double[][] matrixa = {{2,4,7},{2,5,8},{3,6,9}};
		Matrix a=new Matrix(matrixa);
		double [][] matrixb ={{20},{21},{24}};
		Matrix b=new Matrix(matrixb);
		try {
			System.out.println(a.toString());
			double det = MatrixMathematics.determinant(a);
			System.out.println(det);
		} catch (NoSquareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Matrix aInverse=MatrixMathematics.inverse(a);
			System.out.println(aInverse.toString());
			System.out.println(b.toString());
			Matrix ergebnis =MatrixMathematics.multiply(aInverse, b);
			System.out.println(ergebnis.toString());

		} catch (IllegalDimensionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSquareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
