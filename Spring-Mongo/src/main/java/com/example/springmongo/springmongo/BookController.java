package com.example.springmongo.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.InvalidMongoDbApiUsageException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLClientInfoException;
import java.sql.SQLDataException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/getBook")
    public Book getBook(@RequestParam(value = "id") String id){

        int id_ = Integer.parseInt(id);
        return bookRepository.findById(id_);
    }

    @PostMapping(value = "/insertBook")
    public void insertBook(@RequestBody CreateRequest createRequst){

        bookRepository.save(new Book(createRequst.getId(), createRequst.getBookName(), createRequst.getAuthorName(), createRequst.getCost()));
    }

    @DeleteMapping(value = "/deleteBook")
    public void deleteBook(@RequestParam(value = "id") String id){
        int id_ = Integer.parseInt(id);
        bookRepository.deleteById(id_);
    }


}
