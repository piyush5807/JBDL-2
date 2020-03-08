package com.example.jpaexample.demojpaexample;

import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

//    @GetMapping(value = "/getBook")
//    public List<Book> getAllBook(){
//
//        return bookRepository.findAll();
//    }

    @PostMapping(value = "/insertBook")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertBook(@RequestBody CreateRequest createRequest) throws Exception{

        try {
            Book book = new Book(createRequest.getName(), createRequest.getAuthor(), createRequest.getCost());

            bookRepository.save(book);

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    @GetMapping(value = "/getBookByAuthor")
    public List<Book> getBookByAuthorName(@RequestParam(value = "a") String auth, @RequestParam(value = "cost") int ocst){
        List<Book> books = bookRepository.findByAuthorName(auth);
        System.out.println(books);
        return books;
    }

    // Maven:org.hibernate:hibernate-coreL5.4.12.Final -> hibernate-core-5.4.12.Final.jar org.hibernate -> query
}