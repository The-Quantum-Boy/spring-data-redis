package com.sumit.service;

import com.sumit.model.Order;
import com.sumit.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> search(String commodityCode) {

        return orderRepo.search(commodityCode);
    }
}
