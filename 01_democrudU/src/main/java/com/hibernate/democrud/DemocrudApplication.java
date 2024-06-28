package com.hibernate.democrud;

import com.hibernate.democrud.dao.StudentDAO;
import com.hibernate.democrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemocrudApplication {

	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			createMultipleStudent();
		};
	}

	public void createStudent() {
		Student s1 = new Student("Rohit Paudel", "rohit@ronb.com", "Kathmandu");
		studentDAO.save(s1);
		System.out.println("Record saved successfully with ID: " + s1.getId());
	}
	public void createMultipleStudent() {
		System.out.println("Inserting Record of Student");
		Student s1 = new Student("Rohit Paudel", "rohit@ronb.com", "Kathmandu");
		Student s2 = new Student("Kamal Singh", "kamal@ronb.com", "Pokhara");
		Student s3 = new Student("Sahil Sharma", "sahil@ronb.com", "Dharan");

		System.out.println("Record is about ot save...");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
		System.out.println("Record saved successfully with ID: " + s1.getId());
		System.out.println("Record saved successfully with ID: " + s2.getId());
		System.out.println("Record saved successfully with ID: " + s3.getId());
	}
}
