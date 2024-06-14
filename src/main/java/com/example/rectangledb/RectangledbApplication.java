package com.example.rectangledb;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RectangledbApplication {

	public static void main(String[] args) {
		// Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();

        // Set system properties for Spring Boot to use
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(RectangledbApplication.class, args);
	}

}
