package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.Room;

public interface RoomRepositor extends JpaRepository<Room, Integer> {
    
    // Additional query methods can be defined here if needed

}
