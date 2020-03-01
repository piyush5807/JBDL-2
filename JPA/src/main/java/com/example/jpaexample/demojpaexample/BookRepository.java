package com.example.jpaexample.demojpaexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM Book b WHERE b.a_name = :authorname", nativeQuery = true)
    List<Book> findByAuthorName(String authorname);
}
