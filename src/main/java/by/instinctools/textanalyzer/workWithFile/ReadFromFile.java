package by.instinctools.textanalyzer.workWithFile;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class for reading of txt-file.
 */
public class ReadFromFile {
	private static String textString;

	/**
	 * Reading of txt-file in string.
	 * 
	 * @param fileName
	 *            The Name and path to txt-file for reading.
	 * @return Readed string.
	 * @throws Exception
	 */
	public static String readFile(String fileName) throws Exception {
		textString = new String(Files.readAllBytes(Paths.get(fileName)));
		return textString;
	}
}
