package by.instinctools.textanalyzer.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.instinctools.textanalyzer.AnalyzeModel;
import by.instinctools.textanalyzer.workWithFile.FileAnalyze;
import by.instinctools.textanalyzer.workWithFile.ReadFromFile;

@RestController
public class TextAnalyzerController {

	@RequestMapping
	public String showResult(@RequestParam("path") AnalyzeModel uploadfile) throws Exception {
		String textString = ReadFromFile.readFile(uploadfile.getPath());
		String bracketValue = FileAnalyze.bracketChecker(textString);
		String analyzeResult = Arrays.toString(FileAnalyze.repeatChecker(textString));
		return "Placement and number of bracket: " + bracketValue + "\n Top 10 must repeated words in the text: \n"
				+ analyzeResult;
	}
}
