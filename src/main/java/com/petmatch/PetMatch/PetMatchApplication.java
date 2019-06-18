package com.petmatch.PetMatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetMatchApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
	};
	}

}
