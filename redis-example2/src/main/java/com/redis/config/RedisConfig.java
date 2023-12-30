package com.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Slf4j
public class RedisConfig {

    @Bean
    public RedisTemplate<?,?> redisTemplate(RedisConnectionFactory connectionFactory){
        log.info("from the redis template {}",connectionFactory.toString());
        RedisTemplate<?,?> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
