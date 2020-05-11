package com.example.demojdbc.jdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DBConnection.getConnection();
//		DBConnection.createTable("person");

		Person person = new Person("Karan", "Gupta", 26);
		DBConnection.insertPerson(person);
//		System.out.println("*************** Fetching all Persons from DB ************************");
//		System.out.println(DBConnection.getAllPerson());
//
////		System.out.println("************** Fetching Person with ID 2 from DB *******************");
////		System.out.println(DBConnection.getPersonbyId(2));
////
////		System.out.println("******************Deleting Person with id 2 from DB*****************");
////		DBConnection.deletePersonBYId(2);
//
		DBConnection.closeConnection();
	}

}
