package by.instinctools.textanalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class.
 */
@SpringBootApplication
public class RunAnalize {
	/**
	 * Point to enter the application for reading and analysis txt-file.
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RunAnalize.class, args);
		
	}
}
