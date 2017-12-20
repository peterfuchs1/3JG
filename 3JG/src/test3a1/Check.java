package test3a1;
public interface Check {

	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		return str == null ? true : "".equals(str) ? true : false;
	}
}