package com.cinema.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.cinema.entity.ReservedSeat;

public interface ReservedSeatRepository extends JpaRepository<ReservedSeat, Integer> {

    List<ReservedSeat> findAllByReservationId(int reservationId);

    // Additional query methods can be defined here if needed

}
