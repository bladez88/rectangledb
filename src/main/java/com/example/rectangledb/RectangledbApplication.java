package com.example.rectangledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class RectangledbApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RectangledbApplication.class, args);

        // Accessing environment variables directly after context is initialized
        String apiKey = System.getenv("API_KEY");
        String dbUrl = System.getenv("DATABASE_URL");

        System.out.println("API Key: " + apiKey);
        System.out.println("Database URL: " + dbUrl);
    }
}
