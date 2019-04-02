package matrix;
/**
 * If the Matrix has different rows and cols:
 * It's not allowed to make a determinant, an inverse matrix or a cofactor matrix
 * 
 * @author Walter Rafeiner-Magor
 *
 */
public class NoSquareException extends Exception {
	private static final long serialVersionUID = 8834044998910102747L;
	/**
	 * standard constructor
	 */
	public NoSquareException() {
		super();
	}
	/**
	 * constructor with message
	 * @param message for this exception
	 */
	public NoSquareException(String message) {
		super(message);
	}

}
