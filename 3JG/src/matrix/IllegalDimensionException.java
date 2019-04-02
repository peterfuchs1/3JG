package matrix;
/**
 * An addition or a subtraction of two matrices must have the same dimension.
 * A multiplication is only allowed, if the number of columns in matrix one
 * is equal to the number of rows in matrix two.
 * 
 * @author Walter Rafeiner-Magor
 *
 */
public class IllegalDimensionException extends Exception {

	private static final long serialVersionUID = -7452581385148098883L;
	/**
	 * standard constructor
	 */
	public IllegalDimensionException() {
		super();
	}
	/**
	 * constructor with message
	 * @param message for this exception
	 */
	public IllegalDimensionException(String message) {
		super(message);
	}
}
