package file;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFile {

   public static void main(String args[]) throws IOException {  
		 Files.write(Paths.get("output.txt"),
				 Files.readAllBytes(Paths.get("input.txt")));
	   
//      	try(
//      		FileInputStream in = new FileInputStream("input.txt");
//      		FileOutputStream out = new FileOutputStream("output.txt")
//        	){
//         int c;
//         while ((c = in.read()) != -1) {
//            out.write(c);
//         }
//      }
   }
}