package com.smtp.notify.service;

import org.springframework.stereotype.Service;

public interface RedisSubscriberService {

    Boolean subscribeToChannel();

    Boolean unsubscribeFromChannel();
}
