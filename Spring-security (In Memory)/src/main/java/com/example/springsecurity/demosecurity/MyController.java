package com.example.springsecurity.demosecurity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

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


    @Secured({"my_role2"})
    @RequestMapping(value = "/user2", method = RequestMethod.GET)
    public String greetUserPost(){
        return "Hi Admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String greetAdmin(){
        return "Hi admin, ";
    }


    // my_role1 -> user
    // my_role2 -> admin

}
