package lgs;
/**
 * Test-Klasse <br>
 * Testet ein lineares Gleichungssystem in 3 Variablen und 3 Gleichungen<br>
 * <br>
 * @author Walter Rafeiner-Magor
 *
 */
public class Main {

    public static void main(String args[])
    {
		double[][] matrixa = {{2,4},{5,8}};
		double[][] matrixb ={{16},{34}};
		LGS lgs=null;
		try {
			lgs = new LGS(matrixa, matrixb);
		} catch (IllegalDimensionException | NoSquareException e) {
			e.printStackTrace();
		}
		System.out.println(LGS.toString(matrixa));
		System.out.println(LGS.toString(matrixb));
		try {
			double[][] loesungen=lgs.solve();
			System.out.println(LGS.toString(loesungen));
		} catch (MatrixException e) {
			e.printStackTrace();
		}
		
    }

}
