package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyTextFile {
	public static void main(String args[]) throws IOException {
		 Files.write(
				 Paths.get("output.txt"),
				 Files.readAllBytes(Paths.get("input.txt"))
				 );
	
		
//		try (	FileReader in = new FileReader("input.txt");
//				FileWriter out = new FileWriter("output.txt")) {
//			int c;
//			while ((c = in.read()) != -1) {
//				out.write(c);
//			}
//		}
	}
}
