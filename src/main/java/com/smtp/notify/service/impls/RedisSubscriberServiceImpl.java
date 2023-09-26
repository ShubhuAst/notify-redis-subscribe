package com.smtp.notify.service.impls;

import com.smtp.notify.service.RedisSubscriberService;
import com.smtp.notify.subscribe.RedisSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class RedisSubscriberServiceImpl implements RedisSubscriberService{

    @Autowired
    RedisSubscriber redisSubscriber;

    @Autowired
    ChannelTopic topic;

    @Autowired
    MessageListenerAdapter listenerAdapter;

    @Override
    public Boolean subscribeToChannel() {
        return redisSubscriber.subscribeToChannel(listenerAdapter, topic);
    }

    @Override
    public Boolean unsubscribeFromChannel() {
        return redisSubscriber.unsubscribeFromChannel(listenerAdapter, topic);
    }
}
