package com.perfectJava;

import com.perfectJava.entities.UserProfile;
import com.perfectJava.repository.UserProfileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
@EnableCaching
public class RedisExample4Application implements CommandLineRunner {

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("usersProfile");
	}
	@Autowired
	private UserProfileRepo repo;
	private Logger log= LoggerFactory.getLogger(RedisExample4Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisExample4Application.class, args);
	}

	@Override
	public void run(String... args){

//		log.info("Adding user profiles..");
//		UserProfile user1= UserProfile.builder()
//				.name("Rajesh")
//				.follower(100000L)
//				.build();
//
//		UserProfile user2= UserProfile.builder()
//				.name("Sachin")
//				.follower(500000L)
//				.build();
//
//		UserProfile user3= UserProfile.builder()
//				.name("Shaktiman")
//				.follower(1000L)
//				.build();
//
//		repo.saveAll(List.of(user1,user2,user3));
//
//		log.info("Added User Profile");

	}

}
