package com.example.springmongo.springmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer> {

    Book findById(int id);

    void deleteById(int id);

}
