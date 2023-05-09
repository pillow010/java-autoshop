package com.automotoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 The AutomotoShopApplication class is the entry point of the Spring Boot application.
 It starts the application and runs it.
 */
@SpringBootApplication
public class AutomotoShopApplication {

	/**
	 The main method is the entry point of the application.
	 It starts the Spring Boot application and runs it.
	 @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AutomotoShopApplication.class, args);
	}

}
