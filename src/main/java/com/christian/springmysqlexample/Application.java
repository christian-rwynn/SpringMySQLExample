package com.christian.springmysqlexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private final ISchoolService schoolService;
	private final IStudentService studentService;

	public Application(ISchoolService schoolService, IStudentService studentService) {
		this.schoolService = schoolService;
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int seed = 50;
		log.info("...Creating schools...");
		List<School> schools = new ArrayList<>(
				Arrays.asList(
			new School("University of Applied Sciences and Technology"),
			new School("O.S. Petunia"),
			new School("K.R.S. Colleridge"),
			new School("Natuurtechnisch Instituut")
		));

		log.info("...Saving schools...");
		schoolService.saveAll(schools);
		Iterable<School> iterator = schoolService.findAll();
		iterator.forEach(item -> System.out.println(item));

		log.info("...Generating students...");
		List<Student> students = new ArrayList<>(
			Arrays.asList(
				new Student("Mitch", "Christian"),
				new Student("Gersion", "Christian"),
				new Student("Wintje", "Christian"),
				new Student("Mersion", "Mikaelson"),
				new Student("Eagle", "Birdhouse")
			)
		);

		log.info("...Assign schools to students...");
		students.forEach(student -> {
			int randValue = new Random().nextInt(schools.size());
			student.setSchool(schools.get(randValue));
		});

		log.info("...Saving students...");
		studentService.saveAll(students);
	}
}
