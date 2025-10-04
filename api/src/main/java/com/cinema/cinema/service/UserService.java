package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.UserRequestDto;
import com.cinema.cinema.entity.User;
import com.cinema.cinema.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ApplicationEventPublisher publisher;

    @Autowired
    public UserService(UserRepository userRepository, ApplicationEventPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User deleteUserById(int id) {
        User user = getUserById(id);
        if (user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    public User updateUser(int id, UserRequestDto userRequestDto) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setName(userRequestDto.name());
            existingUser.setEmail(userRequestDto.email());
            existingUser.setPassword(userRequestDto.password());
            existingUser.setRole(userRequestDto.role());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public User addUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .name(userRequestDto.name())
                .email(userRequestDto.email())
                .password(userRequestDto.password())
                .role(userRequestDto.role())
                .build();
        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            return null;
        }
        publisher.publishEvent(savedUser);
        return savedUser;
    }
}
