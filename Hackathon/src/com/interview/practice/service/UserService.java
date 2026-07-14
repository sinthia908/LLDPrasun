package com.interview.practice.service;

import com.interview.practice.model.User;
import com.interview.practice.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
           this.userRepository = userRepository;
    }

    public User addUser(String name, String department){
        User user = new User(name,department);
        userRepository.save(user);
        return user;
    }
}
