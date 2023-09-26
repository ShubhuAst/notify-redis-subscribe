package com.smtp.notify.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber {

    @Autowired
    RedisMessageListenerContainer redisMessageListenerContainer;

    public Boolean subscribeToChannel(MessageListenerAdapter listenerAdapter, ChannelTopic topic) {
        try{
            redisMessageListenerContainer.addMessageListener(listenerAdapter, topic);
            return true;
        }catch (Exception e){
            System.out.println("Error while subscribing: "+e);
            return false;
        }
    }

    public Boolean unsubscribeFromChannel(MessageListenerAdapter listenerAdapter, ChannelTopic topic) {
        try{
            redisMessageListenerContainer.removeMessageListener(listenerAdapter, topic);
            return true;
        }catch (Exception e){
            System.out.println("Error while unsubscribing: "+e);
            return false;
        }
    }

}
