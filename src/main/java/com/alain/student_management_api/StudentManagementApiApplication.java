package com.alain.student_management_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class StudentManagementApiApplication {

	// Inject our StudentRepository interface so that we can use the saveAll() method in our CommandLineRunner run method below
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApiApplication.class, args);
	}

	// Add Students to database when application starts up
	@Bean
	public CommandLineRunner run() {
		return args -> {
			Student alain = new Student("Alain", "Picard", "alain@gmail.com", LocalDate.of(1999, Month.FEBRUARY, 26));
			Student elon = new Student("elon", "musk", "elon@gmail.com", LocalDate.of(1985, Month.MARCH, 15));
			Student michelle = new Student("Michelle", "Obama", "michelle@gmail.com", LocalDate.of(1984, Month.JULY, 5));
			studentRepository.saveAll(List.of(alain, elon, michelle));
		};
	}
}
