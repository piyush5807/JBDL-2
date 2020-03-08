package com.example.springsecurity.demosecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetEveryOne(){
        return "Hi, ";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String greetUser(){
        return "Hi User, ";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String greetUserPost(){
        return "Hi Admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String greetAdmin(){
        return "Hi admin, ";
    }
}
