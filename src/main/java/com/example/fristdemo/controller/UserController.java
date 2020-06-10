package com.example.fristdemo.controller;

import com.example.fristdemo.doamin.User;
import com.example.fristdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController()
@RequestMapping("/person")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)){
            System.out.println(user.toString());
        }
        return user;
    }


    /*@GetMapping("/find/all")
    public Collection<User> findAll(){
        return userRepository.findAll();
    }*/
}
