/**
 * 
 */
package lgs;

/**
 * Lineare Gleichungssysteme m x m<br>
 * z.B.:<br>
 * 2x+4y+7z=20<br>
 * 2x+5y+8z=21<br>
 * 3x+6y+9z=24<br>
 * wird nun folgendermassen umgesetzt: 
 * <br>
 * matrixA ist ein double[3][3] Array:<br>
 * 2 4 7<br>
 * 2 5 8<br>
 * 3 6 9<br>
 * Die Spalten sind die (Koeeffizienten) der Variablen x, y, z<br>
 * Die einzelnen Zeilen stellen die Gleichungen dar.<br>
 * <br>
 * matrixB ist ein double[3][1] Array:<br>
 * 20<br>
 * 21<br>
 * 24<br>
 * Die Werte stellen die Ergebnisse der Gleichungen dar (rechts vom =)<br>
 * <br>
 * @author Walter Rafeiner-Magor
 *
 */
public class LGS implements Determinante{
	/** Array der Variablen und Gleichungen */
	private double [][] matrixA;
	/** Array der Ergebnisse fuer jede Gleichung*/
	private double [][] matrixB;
	/** Loesungen fuer jede Variable */
	private double [][] matrixE;
	
	/**
	 * gibt das Array mit den Koeffizienten der Variablen je Gleichung zurueck 
	 * @return the matrixA
	 */
	public double[][] getMatrixA() {
		return matrixA;
	}
	/**
	 * setzt das Array mit den Koeffizienten der Variablen je Gleichung
	 * @param matrixA the matrixA to set
	 */
	public void setMatrixA(double[][] matrixA) {
		this.matrixA = matrixA;
	}
	/**
	 * gibt das Array mit den Ergebnissen je Gleichung (rechts vom =) zurueck
	 * @return the matrixB
	 */
	public double[][] getMatrixB() {
		return matrixB;
	}
	/**
	 * setzt das Array mit den Ergebnissen je Gleichung (rechts vom =) 
	 * @param matrixB the matrixB to set
	 */
	public void setMatrixB(double[][] matrixB) {
		this.matrixB = matrixB;
	}
	/**
	 * gibt das Array mit den Loesungen fuer die Variablen zurueck
	 * @return the matrixE
	 */
	public double[][] getMatrixE() {
		return matrixE;
	}
	/**
	 * Konstruktor der linearen Gleichungssysteme
	 * 
	 * @param matrixA Array mit den Koeffizienten der Variablen je Gleichung
	 * @param matrixB Array mit Ergebnissen je Gleichung
	 * @throws IllegalDimensionException wird geworfen, 
	 * wenn die Anzahl der Variablen (Spalten von matrixA)<br>
	 *  nicht mit der Anzahl der Ergebnisse (Zeilen von matrixB) uebereinstimmen.<br>
	 * wird auch geworfen, wenn die Anzahl der Gleichungen (Zeilen von matrixA)<br>
	 *  nicht mit der Anzahl der Ergebnisse (Zeilen von matrixB) uebereinstimmen. <br>
	 * wird auch geworfen, wenn die Anzahl der Ergebnisse pro Gleichung (Spalten von matrixB) nicht <b>1</b> ist.<br>
	 * @throws NoSquareException wird geworfen, wenn die Anzahl der Gleichungen (Zeilen von matrixA)<br>
	 *  und Variablen (Spalten von matrixA) unterschiedlich sind<br> 
	 */
	public LGS(double[][] matrixA, double[][] matrixB) throws IllegalDimensionException, NoSquareException {
		if(LGS.getNCols(matrixA)!=LGS.getNRows(matrixA)) throw
			new NoSquareException("Anzahl der Variaben ("+LGS.getNCols(matrixA)+
					") und Gleichungen ("+getNCols(matrixA)+") stimmen nicht überein");
		if(LGS.getNRows(matrixA)!= LGS.getNRows(matrixB)) throw 
			new IllegalDimensionException("Anzahl der Gleichungen ("+LGS.getNRows(matrixA)+
				") und Ergebniswerte ("+getNRows(matrixB)+") stimmen nicht überein");
		
		if (LGS.getNCols(matrixA)!= LGS.getNRows(matrixB)) throw 
			new IllegalDimensionException("Anzahl der Variablen ("+LGS.getNCols(matrixA)+
				") und Ergebniswerte ("+getNRows(matrixB)+") stimmen nicht überein");
		if (LGS.getNCols(matrixB)!= 1) throw 
			new IllegalDimensionException("Die Anzahl der Ergebnisspalten muss immer 1 sein! => "+
				LGS.getNCols(matrixB));

		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixE = new double [matrixB.length][1];

	}
	/**
	 * berechnet die Loesungen des linearen Gleichungssystems<br>
	 * Die Loesungen koennen auch nach der Berechung mittels toString<br>
	 * ausgegeben werden. 
	 * @return Array mit allen Loesungen (in den Zeilen)
	 * @throws MatrixException wird geworfen, <br>falls es keine oder
	 *  unendlich viele Loesungen gibt
	 */
	public double[][] solve() throws MatrixException {
		double solvable=this.determinant(this.matrixA);
		if(solvable==0) {
			throw new MatrixException("Diese Gleichung ist leider nicht lösbar!");
		}
		double[][] cfm = cofactor(matrixA);
		double[][] tpm = transpose(cfm);
		solvable =1.0/solvable;
		double[][] ivm = multiplyByConstant(tpm, solvable);

		matrixE = multiply(ivm, matrixB);

		return matrixE;
	}
	/**
	 * berechnet die Anzahl der Zeilen des Arrays m
	 * @param m Array
	 * @return Anzahl der Zeilen
	 */
	public static int getNRows(double[][] m) {
		return m.length;
	}
	/**
	 * berechnet die Anzahl der Spalten des Arrays m
	 * @param m Array
	 * @return Anzahl der Spalten
	 */
	public static int getNCols(double[][] m) {
		return m[0].length;
	}
	/**
	 * {@link java.lang.Object#toString()}
	 */
	@Override
	public String toString() {
		return LGS.toString(matrixE);
	}
	/**
	 * erstellt fuer das Array m eine String-Entsprechung 
	 * @param m Array
	 * @return String-Darstellung des Arrays
	 */
	public static String toString(double[][] m) {
		StringBuffer s=new StringBuffer();
		for (int i = 0; i < getNRows(m); i++) {
			for (int j = 0; j < getNCols(m); j++) {
				s.append(m[i][j]).append(' ');
			}
			s.append('\n');
		}
		return s.toString();
		
	}
	private double determinant(double a[][]) {
		return determinant(a,a.length);
	}
    private double determinant(double a[][],int n)
    {
        double det=0;
        if(n == 1) return a[0][0];
        else if (n == 2)
            return a[0][0]*a[1][1] - a[1][0]*a[0][1];
        else
        {
            det=0;
            for(int j1=0;j1<n;j1++)
            {
                double[][] m = new double[n-1][];
                for(int k=0;k<(n-1);k++)
                    m[k] = new double[n-1];

                for(int i=1;i<n;i++)
                {
                    int j2=0;
                    for(int j=0;j<n;j++)
                    {
                        if(j == j1)
                            continue;
                        m[i-1][j2] = a[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0,1.0+j1+1.0)* a[0][j1] * determinant(m,n-1);
            }
        }
        return det;
    }
	private static int changeSign(int i) {
		return (i%2==0)?1:-1;
	}
	private double[][]  createSubMatrix(double[][] matrix, int excluding_row, int excluding_col) {
		double[][] mat = new double[getNRows(matrix)-1][getNCols(matrix)-1];
		int r = -1;
		for (int i=0;i<getNRows(matrix);i++) {
			if (i==excluding_row)
				continue;
				r++;
				int c = -1;
			for (int j=0;j<getNCols(matrix);j++) {
				if (j==excluding_col)
					continue;
				mat[r][++c]= matrix[i][j];
			}
		}
		return mat;
	}
	private double[][] cofactor(double[][] matrix){
		double[][] mat = new double[getNRows(matrix)][getNCols(matrix)];
		for (int i=0;i<getNRows(matrix);i++) {
			for (int j=0; j<getNCols(matrix);j++) {
				mat[i][j]=changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j));
			}
		}
		
		return mat;
	}
    private double[][] transpose(double[][] matrix) {
        double[][] transposedMatrix = new double[getNCols(matrix)][getNRows(matrix)];
        for (int i=0;i<getNRows(matrix);i++) {
            for (int j=0;j<getNCols(matrix);j++) {
                transposedMatrix[j][i]=matrix[i][j];
            }
        }
        return transposedMatrix;
    }
    private double[][] multiplyByConstant(double[][] matrix, double constant) {
        double[][] mat = new double[getNCols(matrix)][getNRows(matrix)];
        for (int i=0;i<getNRows(matrix);i++) {
            for (int j=0;j<getNCols(matrix);j++) {
                mat[i][j]=matrix[i][j]*constant;
            }
        }
        return mat;
    }
	private double[][] multiply(double[][] matrix1,double[][] matrix2){
		double[][] multipliedMatrix = new double[getNRows(matrix1)][getNCols(matrix2)];
		
		for (int i=0;i<getNRows(multipliedMatrix);i++) {
			for (int j=0;j<getNCols(multipliedMatrix);j++) {
				double sum = 0.0;
				for (int k=0;k<getNCols(matrix1);k++) {
					sum += matrix1[i][k] * matrix2[k][j];
				}
				multipliedMatrix[i][j]=sum;
			}
		}
		return multipliedMatrix;
	}
	/**
	 * not implemented yet
	 */
	@Override
	public int evaluate() {
		return 0;
	}
    
}
