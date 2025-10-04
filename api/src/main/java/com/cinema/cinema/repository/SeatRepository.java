package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    
    // Additional query methods can be defined here if needed

}
