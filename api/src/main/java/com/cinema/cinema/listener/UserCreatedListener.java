package com.cinema.cinema.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cinema.cinema.entity.User;

@Component
public class UserCreatedListener {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserCreatedListener.class);

    @EventListener
    public void onUserCreated(User user) {
        // Handle user created event
        logger.info("User created: {} - {}", user.getName(), user.getEmail());
    }

}
