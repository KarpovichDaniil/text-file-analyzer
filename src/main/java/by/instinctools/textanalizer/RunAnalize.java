package by.instinctools.textanalizer;

import by.instinctools.textanalizer.workWithFile.AnalyzeFile;
import by.instinctools.textanalizer.workWithFile.ReadFromFile;

/**
 * Main application class.
 */
public class RunAnalize {
	/**
	 * Point to enter the application for reading and analysis txt-file.
	 */
	public static void main(String[] args) throws Exception {
		String textString = ReadFromFile.readFile("d:/text.txt");
		System.out.println("Text from file: " + textString);
		System.out.println(AnalyzeFile.bracketChecker(textString));
		AnalyzeFile.repeatChecker(textString);
	}
}
