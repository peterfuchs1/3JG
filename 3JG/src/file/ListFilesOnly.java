package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFilesOnly {

	public static void main(String[] args) throws IOException {
		Files.list(Paths.get("./"))
			.filter(Files::isRegularFile)
			.forEach(System.out::println);

	}

}
