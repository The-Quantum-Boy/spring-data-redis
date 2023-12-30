package com.sumit.controller;

import com.sumit.model.Order;
import com.sumit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/search")
    public List<Order> search(
            @RequestParam(name = "commodityCode",required = false) String  commodityCode
            ){
        return orderService.search(commodityCode);
    }
}
