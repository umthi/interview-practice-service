package com.theCuriousCoder.interview_practice_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/insert")
    public void insert() {
        userRepository.save(new UserEntity(1l, "Abshishek"));
    }

    @PostMapping("/insert-user")
    public String insertUser(@RequestParam Long id, @RequestParam String name) {
        userRepository.save(new UserEntity(id, name));
        return "User inserted successfully with ID: " + id + " and Name: " + name;
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}


//video link: https://youtu.be/1P1MswyGlOU?si=VE_NEcfMmgcboV8P
