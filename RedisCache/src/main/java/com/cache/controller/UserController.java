package com.cache.controller;

import com.cache.model.User;
import com.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        boolean res=userService.save(user);
        if (res)
            return ResponseEntity.ok("User created successfully...");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUsers(){
        List<User> users=userService.fetchAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id){
        User user=userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        boolean res=userService.deleteUserById(id);
        if (res){
            return ResponseEntity.ok("User deleted successully...");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
