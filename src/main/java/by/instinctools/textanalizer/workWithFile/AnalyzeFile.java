package by.instinctools.textanalizer.workWithFile;

import java.util.Arrays;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


/**
 * Class for analysis of txt-file.
 */
public class AnalyzeFile {

	/**
	 * Counts the number of repeated words in the text. Excludes from the statistics unions, prepositions and pronouns.
	 * 
	 * @param textString
	 *            Text string to analyze.
	 * @return 
	 */
	public static void repeatChecker(String textString) {
		String unChecked = "on | in | at | since | for | ago | before | to | past | till | untill | by | in | at | on | beside | under | below | over | above | across | through | towards | into | onto | from | about| off | i | you | he | she | it | we | they | me | him | her | us | them | mine | yours | his | hers | ours | theirs | this | that | these | those | who | whom | which | what | whose | whoever | whatever | whichever | whomever | myself | yourself | himself | herself | itself | ourselves | themselves | anything | everybody | another | each | few | many | none | some | all | any | anybody | anyone | everyone | everything | nobody | nothing | none | other | others | several | somebody | someone | something | most | enough | little | more | both | either | neither | one | much | such";
		textString = textString.replaceAll(unChecked, " ");
		String[] split = textString.split("[,;:.!?\\s]+");
		Arrays.stream(split)
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
		        .forEach(System.out::println);
		//Map<String, Long> treeMap = new TreeMap<String, Long>(resultMap);
		//return treeMap;
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
