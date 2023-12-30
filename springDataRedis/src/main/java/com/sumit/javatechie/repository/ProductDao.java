package com.sumit.javatechie.repository;

import com.sumit.javatechie.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;
    private static final String HASH_KEY="Product";

    public Product saveProduct(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> getAllProduct(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        System.out.println("ProductDao.findProductById");
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Product Removed...";
    }
}
