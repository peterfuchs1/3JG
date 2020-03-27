package generics;

public interface Discountable {
	public double getCharge();
	public default double getDiscountedCharge(int ps) {
		return (getCharge()*(100-ps));
	}
	public static boolean checkRange(int ps) {
		return (ps<=100 && ps>=0);
	}
}
