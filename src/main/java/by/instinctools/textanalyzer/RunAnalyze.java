package by.instinctools.textanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class RunAnalyze {
	/**
	 * Point to enter the application for reading and analysis txt-file.
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RunAnalyze.class, args);
	}
}
