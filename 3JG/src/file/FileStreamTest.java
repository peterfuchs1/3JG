package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStreamTest {
	public static void main(String args[]) throws IOException{

		byte bWrite[] = { 72, 85, 82, 82, 65, 33 };
		Files.write(Paths.get("test.txt"), bWrite);
//		try (OutputStream os = new FileOutputStream("test.txt")) {
//			for (int x = 0; x < bWrite.length; x++) {
//				os.write(bWrite[x]); // writes the bytes
//			}
//		}
		Files.readAllLines(Paths.get("test.txt")).forEach(System.out::println);

//		try (InputStream is = new FileInputStream("test.txt")) {
//			int size = is.available();
//			for (int i = 0; i < size; i++) {
//				System.out.print((char) is.read());
//			}
//		}
	}
}
