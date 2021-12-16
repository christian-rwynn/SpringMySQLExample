package com.christian.springmysqlexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private final ISchoolService schoolService;

	public Application(ISchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("...Creating schools...");
		schoolService.save(new School("University of Applied Sciences and Technology"));
		schoolService.save(new School("K.R.S. Coleridge"));
		schoolService.save(new School("O.S. Petunia"));
		schoolService.save(new School("Anton de Kom Universiteit"));

		Iterable<School> iterator = schoolService.findAll();

		System.out.println("All expense items: ");
		iterator.forEach(item -> System.out.println(item));
	}
}
