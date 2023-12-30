package com.sumit.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;

@Configuration
@Data
public class RedisConfiguration {

    @Bean
    JedisPooled jedisPooled() {
        return new JedisPooled(
                "redis-14525.c283.us-east-1-4.ec2.cloud.redislabs.com",
                14525,
                "default",
                "oKTDMGIxCWRVf9swdPi3zeUQZ1FF5e7Z"
                );
    }
}
