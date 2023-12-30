package com.redisearch.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.redisearch.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    @Autowired
    private JedisPooled jedis;

    @Autowired
    private String luaScript;

    private final Gson gson = new Gson();

    public Order save(Order order) {
        Gson gson = new Gson();
        String key = order.getInternalOrdNo();
        String jsonOrder = gson.toJson(order);
        jedis.hset("orders", key, jsonOrder);
        return order;
    }



    public List<Order> search(String searchKey) {
        try {
            long startTime = System.currentTimeMillis();
            Object result = jedis.evalsha(
                    luaScript,
                    2,
                    "orders","orders1",
                    searchKey
            );
            System.out.println("Redis execution time -> " + (System.currentTimeMillis()-startTime)+" milli");
            if (result instanceof ArrayList) {
                Type listType = new TypeToken<List<Order>>() {}.getType();
                List<Order> orders = gson.fromJson(result.toString(), listType);
                System.out.println("length 1-> "+orders.size());
                System.out.println(orders);
                return orders;
            }else{
                return Collections.emptyList();
            }
//            if (result instanceof ArrayList) {
//                List<String> resultList = (ArrayList<String>) result;
//                List<Order> orderss = new ArrayList<>();
//                for (int i = 0; i < resultList.size(); i++) {
//                    String json = resultList.get(i);
//                    Order order = gson.fromJson(json, Order.class);
//                    orderss.add(order);
//                }
//
//                System.out.println("Length 2 -> " + orderss.size());
//                System.out.println(orderss);
//                return orderss;
//            } else {
//                return Collections.emptyList();
//            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<Order> search(String searchKey) {
//        try {
//            System.out.println("jedis " + System.currentTimeMillis());
//            Object result = jedis.evalsha(luaScript, 1, "orders", searchKey);
//            System.out.println("jedis " + System.currentTimeMillis());
//
//            if (result instanceof ArrayList) {
//                List<String> resultList = (ArrayList<String>) result;
//
//                Gson gson = new Gson();
//
//                List<Order> orders = resultList.parallelStream()
//                        .filter(json -> {
//                            String lowerJson = json.toLowerCase();
//                            return lowerJson.contains(searchKey);
//                        })
//                        .map(json -> gson.fromJson(json, Order.class))
//                        .collect(Collectors.toList());
//
//                System.out.println("Length -> " + orders.size());
//                System.out.println(orders);
//                return orders;
//            } else {
//                return Collections.emptyList();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
