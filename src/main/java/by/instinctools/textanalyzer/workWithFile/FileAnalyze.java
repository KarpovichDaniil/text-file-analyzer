package by.instinctools.textanalyzer.workWithFile;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Class for analysis of txt-file.
 */
public class FileAnalyze {

	/**
	 * Counts the number of repeated words in the text. Excludes from the statistics conjunctions, prepositions and pronouns.
	 * 
	 * @param textString
	 *            Text string to analyze.
	 * @return 
	 * 			  Top 10 must repeated words in the text.
	 * @throws Exception 
	 */
	public static Object[] repeatChecker(String textString) throws Exception {
		Object[] result;
		String[] split = textString.toLowerCase().split("[\\pP\\s\\d]+");
		String unChecked = ReadFromFile.readFile("unChecked.txt");
		Arrays.asList(split).replaceAll(s -> unChecked.contains(s) ? "" :s);
		result = Arrays.stream(split)
				.filter(s -> !s.isEmpty())
		        .collect(groupingBy(s -> s, counting()))
		        .entrySet()
		        .stream()
		        .sorted(
			            (s1, s2) -> {
			                final int res = s2.getValue().compareTo(s1.getValue());
			                return res == 0 ? s1.getKey().compareTo(s2.getKey()) : res;
			            }
			        )
		        .limit(10)
		        .toArray();
		return result;
	}

	/**
	 * Check if an equal number of bracket and correct placement
	 * 
	 * @param textString
	 *            Text string to analyze
	 * @return 
	 * 			  String with result
	 */
	public static String bracketChecker(String textString) {
		int counterCurly = 0;
		int counterRound = 0;
		int counterSquare = 0;
		char[] chars = textString.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case '{':
				counterCurly++;
				break;
			case '(':
				counterRound++;
				break;
			case '[':
				counterSquare++;
				break;
			case '}':
				counterCurly--;
				break;
			case ')':
				counterRound--;
				break;
			case ']':
				counterSquare--;
				break;
			default:
				break;
			}
			if (counterCurly < 0 || counterSquare < 0 || counterRound < 0)
				break;
		}
		if (counterCurly == 0 && counterSquare == 0 && counterRound == 0) {
			return "correct";
		} else {
			return "incorrect";
		}
	}
}
