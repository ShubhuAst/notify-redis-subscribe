package com.smtp.notify.configuration;

import com.smtp.notify.service.EmailService;
import com.smtp.notify.subscribe.RedisMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class RedisConfig {

    @Autowired
    EmailService emailService;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("127.0.0.1");
        connectionFactory.setPort(6379);
        return connectionFactory;
    }

    @Bean
    public ChannelTopic topic(){
        return new ChannelTopic("smtp");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(){
        return new MessageListenerAdapter(new RedisMessageListener(emailService));
    }

    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory());
        return redisMessageListenerContainer;
    }

}
