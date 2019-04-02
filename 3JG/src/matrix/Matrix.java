package matrix;
/**
 * standard class for mathematics with matrices
 * 
 * @author Walter Rafeiner-Magor
 *
 */
public class Matrix {

	private int nrows;
	private int ncols;
	private double[][] data;
	/**
	 * constructor with a double array
	 * @param dat array
	 */
	public Matrix(double[][] dat) {
		this.data = dat;
		this.nrows = dat.length;
		this.ncols = dat[0].length;
	}
	/**
	 * constructor with given rows and columns
	 * @param nrow number of rows
	 * @param ncol number of columns
	 */
	public Matrix(int nrow, int ncol) {
		this.nrows = nrow;
		this.ncols = ncol;
		data = new double[nrow][ncol];
	}

	/**
	 * @return the nrows
	 */
	public int getNrows() {
		return nrows;
	}
	/**
	 * @param nrows the nrows to set
	 */
	public void setNrows(int nrows) {
		this.nrows = nrows;
	}
	/**
	 * @return the ncols
	 */
	public int getNcols() {
		return ncols;
	}
	/**
	 * @param ncols the ncols to set
	 */
	public void setNcols(int ncols) {
		this.ncols = ncols;
	}
	/**
	 * @return the data
	 */
	public double[][] getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(double[][] data) {
		this.data = data;
	}
	/**
	 * set a value in our matrix
	 * @param row row to set
	 * @param col column to set
	 * @param value to set
	 */
	public void setValueAt(int row, int col, double value) {
		data[row][col] = value;
	}
	/**
	 * get a value in our matrix
	 * @param row get value in row
	 * @param col get value in column
	 * @return value on given position
	 */
	public double getValueAt(int row, int col) {
		return data[row][col];
	}
	/**
	 * is our matrix a square matrix
	 * @return number of rows == number of columns
	 */
	public boolean isSquare() {
		return nrows == ncols;
	}
	/**
	 * return the size of square matrix
	 * @return number of rows or -1
	 */
	public int size() {
		return (isSquare())? nrows: -1;
	}
	/**
	 * {@link java.lang.Object#toString()}
	 */
	@Override
	public String toString() {
		StringBuffer s=new StringBuffer();
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				s.append(data[i][j]).append(' ');
			}
			s.append('\n');
		}
		return s.toString();
	}
	/**
	 * multiplication of our matrix with a given constant
	 * @param constant value for the multiplication
	 * @return new matrix
	 */
	public Matrix multiplyByConstant(double constant) {
		Matrix mat = new Matrix(nrows, ncols);
		for (int i = 0; i < nrows; i++) {
			for (int j = 0; j < ncols; j++) {
				mat.setValueAt(i, j, data[i][j] * constant);
			}
		}
		return mat;
	}
	/**
	 * append a new column with ones
	 * @return new matrix
	 */
	public Matrix insertColumnWithValue1() {
		Matrix x = new Matrix(this.getNrows(), this.getNcols()+1);
		for (int i=0;i<x.getNrows();i++) {
			for (int j=0;j<x.getNcols();j++) {
				if (j==0)
					x.setValueAt(i, j, 1.0);
				else 
					x.setValueAt(i, j, this.getValueAt(i, j-1));
				
			}
		}
		return x;
	}
}
