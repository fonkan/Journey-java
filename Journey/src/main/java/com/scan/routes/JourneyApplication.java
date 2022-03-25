package com.scan.routes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

// Plugin: React to maven!
// frontend-maven-plugin // Compiles ReactCode (.npm)
// maven-resources-plugin // Copies compiled ReactCode into the static folder in maven

@SpringBootApplication
public class JourneyApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(JourneyApplication.class, args);
	}

}
