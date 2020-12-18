package pl.kozik.PracaMagisterska;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.kozik.PracaMagisterska.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PracaMagisterskaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracaMagisterskaApplication.class, args);
	}

}
