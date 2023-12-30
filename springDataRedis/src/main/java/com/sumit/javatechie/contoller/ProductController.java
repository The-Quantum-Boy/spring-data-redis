package com.sumit.javatechie.contoller;

import com.sumit.javatechie.entity.Product;
import com.sumit.javatechie.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productDao.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return productDao.getAllProduct();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Product", unless = "#result.price > 1000")
    public Product getProductById(@PathVariable int id){
        return productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Product")
    public String removeProduct(@PathVariable int id){
        return productDao.deleteProduct(id);
    }

}
