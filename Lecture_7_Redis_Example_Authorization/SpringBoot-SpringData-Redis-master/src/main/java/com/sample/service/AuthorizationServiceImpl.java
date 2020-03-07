package com.sample.service;

import com.sample.dal.UserDao;
import com.sample.dal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    UserDao userDao;


    public Boolean saveUser(User user){
        return userDao.saveUser(user) ;
    }

    @Override
    public User findByName(String name) {

        return userDao.findByName(name);
    }
}
