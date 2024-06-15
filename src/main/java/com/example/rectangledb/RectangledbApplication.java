package com.example.rectangledb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class RectangledbApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(RectangledbApplication.class, args);
    }

    @Bean
    public void exampleBean() {
        // Accessing environment variables
        String apiKey = env.getProperty("API_KEY");
        String dbUrl = env.getProperty("DATABASE_URL");
        // Use the variables as needed
        System.out.println("API Key: " + apiKey);
        System.out.println("Database URL: " + dbUrl);
    }
}
