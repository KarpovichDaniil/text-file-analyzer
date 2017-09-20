package by.instinctools.textanalizer;

import by.instinctools.textanalizer.workWithFile.AnalyzeFile;
import by.instinctools.textanalizer.workWithFile.ReadFromFile;

/**
 * Main application class
 */
public class RunAnalize {
	/**
	 * Point to enter in application for read and analyze txt-file
	 */
	public static void main(String[] args) throws Exception {
		String textString = ReadFromFile.readFile("d:/anotherJson.txt");
		System.out.println("Text from file: " + textString);
		System.out.println(AnalyzeFile.bracketChecker(textString));
	}
}
