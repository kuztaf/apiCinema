package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.Showtime;

public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {
    
    // Additional query methods can be defined here if needed

}
