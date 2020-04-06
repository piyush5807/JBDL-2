package com.shashi.walletservice.service;

import com.shashi.walletservice.Model.User;
import com.shashi.walletservice.Model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAllUsers(){
        ResponseEntity<UserResponse> forEntity =
                restTemplate.getForEntity("http://127.0.0.1:9011/users", UserResponse.class);
        System.out.println(forEntity.getHeaders());
        if(forEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            return null;
        }
        return forEntity.getBody().getList();
    }

    public User getAUser(int userId){
        ResponseEntity<User> forEntity =
                restTemplate.getForEntity(String.format("http://127.0.0.1:9011/users/%s", userId), User.class);
        System.out.println(forEntity.getHeaders());
        if(forEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            return null;
        }
        return forEntity.getBody();
    }

}

