package com.example.jpaexample.demojpaexample;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaExampleApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book("a", "piyush", 30));
	}
}
