package com.cache.service;

import com.cache.entities.Customer;
import com.cache.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer getCustomerById(int id){
        return repository.findById(id).get();
    }

    public Customer getCustomerBySsn(String ssn){
        return repository.findCustomerBySsn(ssn).get();
    }

    public Customer saveCustomer(Customer customer){
        return repository.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return repository.findAll();
    }

}
