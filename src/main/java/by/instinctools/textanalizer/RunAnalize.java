package by.instinctools.textanalizer;

import java.util.Arrays;

import by.instinctools.textanalizer.workWithFile.FileAnalyze;
import by.instinctools.textanalizer.workWithFile.ReadFromFile;

/**
 * Main application class.
 */
public class RunAnalize {
	/**
	 * Point to enter the application for reading and analysis txt-file.
	 */
	public static void main(String[] args) throws Exception {
		String textString = ReadFromFile.readFile("text.txt");
		System.out.println("Text from file: " + textString);
		System.out.println(FileAnalyze.bracketChecker(textString));
		System.out.println("Top 10 words in text: " +  Arrays.toString(FileAnalyze.repeatChecker(textString)));
	}
}
