package com.cache.service.impl;

import com.cache.entities.Book;
import com.cache.repository.BookRepository;
import com.cache.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books",key = "#book.id")
    public Book updateBook(Book book) {
        Book book1=repository.findById(book.getId()).get();
        book1.setAuthor(book.getAuthor());
        book1.setName(book.getName());
        book1.setEdition(book.getEdition());
        book1.setCategory(book.getCategory());
        repository.save(book1);
        return book1;
    }

    @Override
    @Cacheable(cacheNames = "books",key = "#id")
    public Book getBook(long id) {
        Optional<Book> book = repository.findById(id);
        return book.orElseGet(Book::new);
    }

    @Override
    @CacheEvict(cacheNames = "books",key = "#id")
    public String deleteBook(long id) {
        repository.deleteById(id);
        return "Book deleted";
    }
}
