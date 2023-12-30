package com.sumit.javatechie;

import com.sumit.javatechie.entity.Product;
import com.sumit.javatechie.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class SpringDataRedisApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisApplication.class, args);
	}

}
