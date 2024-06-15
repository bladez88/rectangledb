package com.example.rectangledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class RectangledbApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
		// Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();

        // Set system properties for Spring Boot to use
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(RectangledbApplication.class, args);
		
    }
}
