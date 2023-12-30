package com.redis.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Receiver implements MessageListener {

    Logger log= LoggerFactory.getLogger(Receiver.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Consumed event {}",message);
    }


}
