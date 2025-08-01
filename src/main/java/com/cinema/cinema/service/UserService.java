package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.UserRequestDto;
import com.cinema.cinema.entity.User;
import com.cinema.cinema.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
            existingUser.setName(userRequestDto.getName());
            existingUser.setEmail(userRequestDto.getEmail());
            existingUser.setPassword(userRequestDto.getPassword());
            existingUser.setRole(userRequestDto.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public User addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(userRequestDto.getRole());
        return userRepository.save(user);
    }
}
