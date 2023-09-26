package com.smtp.notify.controller;

import com.smtp.notify.service.RedisSubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisSubscriptionController {

    @Autowired
    private RedisSubscriberService redisSubscriberService;


    @PostMapping("/subscribe")
    public String subscribeToChannel() {
        redisSubscriberService.subscribeToChannel();
        return "Subscribed Successfully";
    }

    @PostMapping("/unsubscribe")
    public String unsubscribeFromChannel() {
        redisSubscriberService.unsubscribeFromChannel();
        return "Unsubscribed Successfully";
    }
}
