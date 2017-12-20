package test3a1;

public class MyArray<T> {
	private T head;
	private Object tail;
	public MyArray() {
		head = new T();
	}
	public static void main(String[] args) {
		MyArray<T> array = new MyArray<T>();
		MyArray<Integer> iarray = new MyArray<Integer>();
		MyArray<int> int_array = new MyArray<int>();
	}
}
