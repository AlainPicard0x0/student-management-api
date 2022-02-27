package com.alain.student_management_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {

		};
	}

}
