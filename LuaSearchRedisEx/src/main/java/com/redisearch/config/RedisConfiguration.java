package com.redisearch.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import redis.clients.jedis.JedisPooled;
import redis.clients.jedis.exceptions.JedisDataException;

@Configuration
@Data
public class RedisConfiguration {

    @Value("classpath:search.lua")
    Resource luaScript;

    @Bean
    JedisPooled jedisPooled() {
        return new JedisPooled(
                "localhost",
                6379
        );
    }


//    @Bean
//    JedisPooled jedisPooled(){
//        return  new JedisPooled(
//                "redis-14525.c283.us-east-1-4.ec2.cloud.redislabs.com",
//                14525,
//                "default",
//                "oKTDMGIxCWRVf9swdPi3zeUQZ1FF5e7Z"
//        );
//    }

    @Bean
    String loadScript() throws Exception {
        String data = new String(luaScript.getInputStream().readAllBytes());
        String searchScript = jedisPooled().scriptLoad(data,"filterKey");
        System.out.println("Loaded Lua Script:\n" + searchScript);
        return searchScript;
    }

}
