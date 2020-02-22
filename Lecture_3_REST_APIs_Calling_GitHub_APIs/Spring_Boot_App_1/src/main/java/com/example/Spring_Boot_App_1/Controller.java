package com.example.Spring_Boot_App_1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;

@RestController
public class Controller {

    @GetMapping("/hi")
    public String getHi(){
        return "Hello";
    }

    @GetMapping("/getCurrentDate")
    public Date getDate(){
        return new Date();
    }
    /*
    http://localhost:9999/search?q=Sachin
    http://localhost:9999/search?q=Sachin
    query parameter
     */
    @GetMapping("/search")
    public String search(@RequestParam("q") String q){
        SearchService searchService = new SearchService();
        return searchService.search(q);
    }
    //  http://localhost:9999/balance/{id}
    // path parameter
    // http://localhost:9999/search/{word}

    @GetMapping("/balance/{id}")
    public int getBalance(@PathVariable("id") String id){
        System.out.println(id);
        return 0;
    }
// ArrayList : 15 - 3,4

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveAUser(@RequestBody User user){
        System.out.println(10);
        return user;
    }

    @PutMapping("/users")
    public User updateAUser(@RequestBody User user){
        System.out.println(user.age);
        return user;
    }

}
