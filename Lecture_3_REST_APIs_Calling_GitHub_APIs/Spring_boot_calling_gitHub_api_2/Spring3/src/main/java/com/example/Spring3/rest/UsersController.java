package com.example.Spring3.rest;

import com.example.Spring3.dto.GitHubUsersResponse;
import com.example.Spring3.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController()
public class UsersController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/api/users")
    public List<User> search(@RequestParam(name = "q") String query) {
        ResponseEntity<GitHubUsersResponse> forEntity =
                restTemplate.getForEntity(String.format("https://api.github.com/search/users?q=%s", query), GitHubUsersResponse.class);
        System.out.println(forEntity.getHeaders());
        return forEntity.getBody().getItems();
    }

    @RequestMapping("/api/users/{login}")
    public User get(@PathVariable("login") String login){
        ResponseEntity<User> forEntity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), User.class);
        return forEntity.getBody();
    }
}
