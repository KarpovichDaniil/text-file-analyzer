package by.instinctools.textanalyzer.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.instinctools.textanalyzer.AnalyzeModel;
import by.instinctools.textanalyzer.workWithFile.FileAnalyze;
import by.instinctools.textanalyzer.workWithFile.ReadFromFile;

/**
 * Controller for {@link AnalyzeModel}
 */
@RestController
public class TextAnalyzerController {

	/**
	 * Method show correct or not placement,number of bracket and Top 10 must repeated words in the text
	 * @param inputPath
	 * 			Path from user request.
	 * @return Result of text analysis.
	 * @throws Exception
	 */
	@RequestMapping
	public String showResult(@RequestParam(value="path", defaultValue="text.txt") AnalyzeModel inputPath) throws Exception {
		String textString = ReadFromFile.readFile(inputPath.getPath());
		String bracketValue = FileAnalyze.bracketChecker(textString);
		String analyzeResult = Arrays.toString(FileAnalyze.repeatChecker(textString));
		return "Placement and number of bracket: " + bracketValue + "\nTop 10 must repeated words in the text: \n"
				+ analyzeResult;
	}
}
