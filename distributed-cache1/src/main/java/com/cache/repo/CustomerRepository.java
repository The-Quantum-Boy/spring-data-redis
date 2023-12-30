package com.cache.repo;

import com.cache.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findCustomerBySsn(String ssn);
}
