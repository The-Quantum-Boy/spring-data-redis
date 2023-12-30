package com.redis.controller;

import com.redis.model.Todo;
import com.redis.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoRepository repository;

    @GetMapping("/getall")
    public List<Todo> getall(){
        return (List<Todo>) repository.findAll();
    }
}
