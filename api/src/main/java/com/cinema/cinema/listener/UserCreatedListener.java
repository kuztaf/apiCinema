package com.cinema.cinema.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cinema.cinema.entity.User;

@Component
public class UserCreatedListener {

    @EventListener
    public void onUserCreated(User user) {
        // Handle user created event
        System.out.println("User created: " + user.getName() + " - " + user.getEmail());
    }

}
