package com.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.ReservedSeat;

public interface ReservedSeatRepository  extends JpaRepository<ReservedSeat, Integer> {
    
    // Additional query methods can be defined here if needed

}
