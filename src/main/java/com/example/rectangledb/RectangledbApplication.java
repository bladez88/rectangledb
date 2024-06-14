import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RectangledbApplication {

    public static void main(String[] args) {
        // Explicitly specify the path to the .env file
        Dotenv dotenv = Dotenv.configure()
                                .directory(".") // Specify the directory where .env file is located
                                .load();

        // Example: Load an environment variable from .env
        String apiKey = dotenv.get("API_KEY");

        // Spring Boot application startup
        SpringApplication.run(RectangledbApplication.class, args);
    }
}
