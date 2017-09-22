package by.instinctools.textanalyzer;

/**
 * Model of application
 */
public class AnalyzeModel {
	private final String path;

	/**
	 * Constructor
	 * @param path 
	 *			Path to file
	 */
	public AnalyzeModel(String path) {
		this.path = path;
	}

	/**
	 * This method to get path for analysis
	 * @return
	 * 			Path to file
	 */
	public String getPath() {
		return path;
	}
}
