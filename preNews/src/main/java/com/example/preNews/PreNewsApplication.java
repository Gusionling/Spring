package com.example.preNews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PreNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreNewsApplication.class, args);
	}

}
