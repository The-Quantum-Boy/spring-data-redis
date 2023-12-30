package com.cache.controller;

import com.cache.entities.Customer;
import com.cache.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    public CustomerService service;

    @GetMapping("/getall")
    public List<Customer> getAllCustomer(){
        return service.getAllCustomer();
    }

    @GetMapping("/getById")
    public Customer getCustomerById(int id){
        return service.getCustomerById(id);
    }

    @PostMapping("/post")
    public Customer saveCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }
}
