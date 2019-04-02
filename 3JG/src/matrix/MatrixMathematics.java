package matrix;

public class MatrixMathematics {

	/**
	 * This class a matrix utility class and cannot be instantiated.
	 */
	private MatrixMathematics(){}
	/**
	 * Transpose of a matrix - Swap the columns with rows
	 * @param matrix input matrix
	 * @return transposed matrix
	 */
	public static Matrix transpose(Matrix matrix) {
		Matrix transposedMatrix = new Matrix(matrix.getNcols(), matrix.getNrows());
		for (int i=0;i<matrix.getNrows();i++) {
			for (int j=0;j<matrix.getNcols();j++) {
				transposedMatrix.setValueAt(j, i, matrix.getValueAt(i, j));
			}
		}
		return transposedMatrix;
	}
	
	/**
	 * Inverse of a matrix [ (A)-1 * A = I ] where I is the identity matrix
	 * A matrix that have inverse is called non-singular or invertible. If the matrix does not have inverse it is called singular.
	 * For a singular matrix the values of the inverted matrix are either NAN or Infinity
	 * Only square matrices have inverse and the following method will throw exception if the matrix is not square.
	 * @param matrix input matrix
	 * @return inverted matrix
	 * @throws NoSquareException  if number of rows is not equal to number of columns
	 */
	public static Matrix inverse(Matrix matrix) throws NoSquareException {
		return (transpose(cofactor(matrix)).multiplyByConstant(1.0/determinant(matrix)));
	}
	
	/**
	 * Determinant of a square matrix
	 * The following function find the determinant recursively. 
	 * @param matrix input matrix
	 * @return determinant
	 * @throws NoSquareException if number of rows is not equal to number of columns
	 */
	public static double determinant(Matrix matrix) throws NoSquareException {
		if (!matrix.isSquare())
			throw new NoSquareException("matrix need to be square.");
		if (matrix.size() == 1){
			return matrix.getValueAt(0, 0);
		}
			
		if (matrix.size()==2) {
			return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
		}
		double sum = 0.0;
		for (int i=0; i<matrix.getNcols(); i++) {
			sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
		}
		return sum;
	}

	/**
	 * Determine the sign; 
	 * even numbers have sign + 
	 * odd numbers have sign -
	 * @param i value to check
	 * @return 1 or -1
	 */
	private static int changeSign(int i) {
		return (i%2==0)?1:-1;
	}
	/**
	 * Creates a submatrix excluding the given row and column
	 * @param matrix input matrix
	 * @param excluding_row number of the exluding row
	 * @param excluding_col number of the excluding column
	 * @return new matrix without the excluding row and column
	 */
	public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
		Matrix mat = new Matrix(matrix.getNrows()-1, matrix.getNcols()-1);
		int r = -1;
		for (int i=0;i<matrix.getNrows();i++) {
			if (i==excluding_row)
				continue;
				r++;
				int c = -1;
			for (int j=0;j<matrix.getNcols();j++) {
				if (j==excluding_col)
					continue;
				mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
			}
		}
		return mat;
	}
	
	/**
	 * The cofactor of a matrix
	 * @param matrix input matrix
	 * @return cofactor matrix
	 * @throws NoSquareException if number of rows not equal to number of columns
	 */
	public static Matrix cofactor(Matrix matrix) throws NoSquareException {
		Matrix mat = new Matrix(matrix.getNrows(), matrix.getNcols());
		for (int i=0;i<matrix.getNrows();i++) {
			for (int j=0; j<matrix.getNcols();j++) {
				mat.setValueAt(i, j, changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j)));
			}
		}
		
		return mat;
	}
	
	/**
	 * Adds two matrices of the same dimension
	 * @param matrix1 first matrix
	 * @param matrix2 second matrix
	 * @return Addition of matrix1 and matrix2
	 * @throws IllegalDimensionException if matrix1 and matrix2 has not the same dimension
	 */
	public static Matrix add(Matrix matrix1, Matrix matrix2) throws IllegalDimensionException {
		if (matrix1.getNcols() != matrix2.getNcols() || matrix1.getNrows() != matrix2.getNrows())
			throw new IllegalDimensionException("Two matrices should be the same dimension.");
		Matrix sumMatrix = new Matrix(matrix1.getNrows(), matrix1.getNcols());
		for (int i=0; i<matrix1.getNrows();i++) {
			for (int j=0;j<matrix1.getNcols();j++) 
				sumMatrix.setValueAt(i, j, matrix1.getValueAt(i, j) + matrix2.getValueAt(i,j));
			
		}
		return sumMatrix;
	}
	
	/**
	 * subtract two matrices using the above addition method. Matrices should be the same dimension.
	 * @param matrix1 first matrix
	 * @param matrix2 second matrix
	 * @return subtraction of matrix1 - matrix2
	 * @throws IllegalDimensionException if matrix1 and matrix2 has not the same dimension
	 */
	public static Matrix subtract(Matrix matrix1, Matrix matrix2) throws IllegalDimensionException {
		return add(matrix1,matrix2.multiplyByConstant(-1));
	}
	
	/**
	 * Multiply two matrices
	 * 
	 * @param matrix1 first matrix
	 * @param matrix2 second matrix
	 * @return new matrix
	 * @throws IllegalDimensionException if the number of columns in matrix1 is equal to the number of rows in matrix2.
	 */
	public static Matrix multiply(Matrix matrix1, Matrix matrix2) throws IllegalDimensionException  {
		if (matrix1.getNcols() != matrix2.getNrows() )
			throw new IllegalDimensionException("The first matrix has "+matrix1.getNcols()+" column(s).\n"
					+ " The second matrix should have "+matrix1.getNcols()+" row(s)!");
		Matrix multipliedMatrix = new Matrix(matrix1.getNrows(), matrix2.getNcols());
		
		for (int i=0;i<multipliedMatrix.getNrows();i++) {
			for (int j=0;j<multipliedMatrix.getNcols();j++) {
				double sum = 0.0;
				for (int k=0;k<matrix1.getNcols();k++) {
					sum += matrix1.getValueAt(i, k) * matrix2.getValueAt(k, j);
				}
				multipliedMatrix.setValueAt(i, j, sum);
			}
		}
		return multipliedMatrix;
	}
}
