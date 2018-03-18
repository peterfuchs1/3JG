package file;

import java.io.IOException;
import java.nio.file.*;

public class ListFilesDirectories {

	public static void main(String[] args) throws IOException{
		Files.list(Paths.get("./"))
        .forEach(System.out::println);

	}

}
