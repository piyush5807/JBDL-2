package com.example.jpaexample.demojpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoJpaExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaExampleApplication.class, args);
	}

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Autowired
    BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {

		Set<Book> books = new HashSet<>();
//		books.add(new Book("Intro to HTML", "A", 30));
//		books.add(new Book("Intro to CSS", "D", 45));
//		books.add(new Book("Intro to Django", "B", 100));
//		bookCategoryRepository.save(new BookCategory("Non Programming Lang", books));
//
//		bookCategoryRepository.deleteById(1);
////
//		bookCategoryRepository.save(new BookCategory("Prog Lang"));

//		bookRepository.save(new Book("gfvjbesd", "A", 300, 5));
		bookRepository.save(new Book("hdvegv", "B", 300, 3));

	}
}
