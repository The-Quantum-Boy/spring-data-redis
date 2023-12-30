package com.sumit.repo;

import com.google.gson.Gson;
import com.sumit.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.resps.ScanResult;
import redis.clients.jedis.resps.Tuple;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.Query;
import redis.clients.jedis.search.SearchResult;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Repository
public class OrderRepo {

    @Autowired
    private JedisPooled jedis;

    public static final Integer PAGE_SIZE = 5;

    public Order save(Order order) {
        Gson gson = new Gson();
        String key = order.getInternalOrdNo();
        jedis.zadd("orders", Double.parseDouble(key), gson.toJson(order));
        return order;
    }

    public void deleteAll() {
        Set<String> keys = jedis.smembers("order");
        if (!keys.isEmpty()) {
            keys.stream().forEach(jedis::jsonDel);
        }
//        jedis.functionFlush();
    }

    public List<Order> search(String commodityCode) {
        Gson gson = new Gson();


//        StringBuilder queryBuilder = new StringBuilder();
//
//        if(commodityCode!=null && !commodityCode.isEmpty()){
//            queryBuilder.append("@commodityCode:"+commodityCode);
//        }
//
//        System.out.println(queryBuilder);
//
//        String queryCriteria = queryBuilder.toString();
//
//        Query query=null;
//
//        if (queryCriteria.isEmpty()){
//            query = new Query();
//        }else{
//            query = new Query(queryCriteria);
//        }

       List<Tuple> allMembers =  jedis.zrangeByScoreWithScores("orders", 0, -1);
        String target = "SCRAP12"; // Replace with the postal_code you're looking for
        System.out.println(allMembers);

        for (Tuple member : allMembers) {
            String jsonOrder = member.getElement();
            Order order = gson.fromJson(jsonOrder, Order.class);

            if (target.equals(order.getCommodityCode())) {
                System.out.println("Matching Member Data: " + jsonOrder.toString());
            }
        }




//        ScanResult<Tuple> zscan = jedis.zscan("orders",'0', "SCRAP17");
//        System.out.println(zscan);

        SearchResult searchResult = jedis.ftSearch("order-idx","$");
        System.out.println(searchResult);
        List<Order> orderList = searchResult.getDocuments()
                .stream()
                .map(this::converDocumentToOrder)
                .collect(Collectors.toList());
        System.out.println(orderList);
        return orderList;
    }

    private Order converDocumentToOrder(Document document){

        Gson gson = new Gson();

        String jsonDoc = document
                .getProperties()
                .iterator()
                .next()
                .getValue()
                .toString();

        return gson.fromJson(jsonDoc, Order.class);
    }
}

