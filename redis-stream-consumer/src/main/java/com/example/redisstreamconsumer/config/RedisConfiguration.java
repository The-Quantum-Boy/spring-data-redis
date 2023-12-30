package com.example.redisstreamconsumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;

@Configuration
public class RedisConfiguration {

    @Value("${stream.key}")
    private String streamKey;

    @Value("${host.redis}")
    private String redisHost;

    @Value("${port.redis}")
    private int redisPort;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisHost);
        configuration.setPort(redisPort);
        return new JedisConnectionFactory(configuration);
    }


    @Autowired
    private StreamListener<String, ObjectRecord<String, String>> streamListener;

    @Bean
    public Subscription subscription() throws UnknownHostException {
        var options = StreamMessageListenerContainer
                .StreamMessageListenerContainerOptions
                .builder()
                .pollTimeout(Duration.ofSeconds(1))
                .targetType(String.class)
                .build();
        var listenerContainer = StreamMessageListenerContainer
                .create(jedisConnectionFactory(), options);
        var subscription = listenerContainer.receive(
//                Consumer.from(streamKey, InetAddress.getLocalHost().getHostName()),
//                StreamOffset.create(streamKey, ReadOffset.latest()), //takes latest value
                StreamOffset.create(streamKey, ReadOffset.from("0")), //this also takes past value
                streamListener);
        listenerContainer.start();
        return subscription;
    }
}
