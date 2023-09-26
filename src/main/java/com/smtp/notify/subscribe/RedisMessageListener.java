package com.smtp.notify.subscribe;

import com.smtp.notify.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    private EmailService emailService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        System.out.println("Received message from channel " + channel + ": " + messageBody);
        emailService.sendSimpleEmail("shubham.asthana@tothenew.com", messageBody, "New User Added!");
    }
}
