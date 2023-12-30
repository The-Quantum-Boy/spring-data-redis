package com.cache.controller;

import com.cache.entities.Book;
import com.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return service.addBook(book);
    }


    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return service.updateBook(book);
    }

    @GetMapping("/get/{id}")
    public Book getBook(@PathVariable long id){
        return service.getBook(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(long id){
        return service.deleteBook(id);
    }
}
