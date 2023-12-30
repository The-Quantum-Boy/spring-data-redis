package com.redis.config;

import com.redis.subscriber.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionFactory(){
        RedisStandaloneConfiguration config=new RedisStandaloneConfiguration();
        config.setHostName("localhost");
        config.setPort(6379);
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Object> template(){
        RedisTemplate<String, Object> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }

    @Bean
    public ChannelTopic topic(){
        return new ChannelTopic("pubsub:my-channel");
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(){
        return new MessageListenerAdapter(new Receiver());
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.addMessageListener(messageListenerAdapter(),topic());
        return container;
    }
}
