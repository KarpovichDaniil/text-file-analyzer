package by.instinctools.textanalizer.workWithFile;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for reading txt-file
 */
public class ReadFromFile {
	private static String fileString;

	/**
	 * Reading txt-file in string
	 * 
	 * @param fileName
	 *            Name and Path to txt-file for read
	 * @return String from file reading
	 * @throws Exception
	 */
	public static String readFile(String fileName) throws Exception {
		fileString = new String(Files.readAllBytes(Paths.get(fileName)));
		return fileString;
	}
}
