package com.knowledgepioneer.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * This application lets a client write the file present in local storage to 
 * database using the rest api call and subsequently read and delete the 
 * content stored in the database.
 * 
 * @author Samundra karki
 * 
 * */

@SpringBootApplication
public class RecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordsApplication.class, args);
	}
}
