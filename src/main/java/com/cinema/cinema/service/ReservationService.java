package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.ReservationRequestDto;
import com.cinema.cinema.entity.Reservation;
import com.cinema.cinema.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation deleteReservationById(int id) {
        Reservation reservation = getReservationById(id);
        if (reservation != null) {
            reservationRepository.delete(reservation);
            return reservation;
        }
        return null;
    }

    public Reservation updateReservation(int id, ReservationRequestDto reservationRequestDto) {
        Reservation existingReservation = getReservationById(id);
        if (existingReservation != null) {
            existingReservation.setUserId(reservationRequestDto.getUserId());
            existingReservation.setMovieId(reservationRequestDto.getMovieId());
            existingReservation.setReservationTime(reservationRequestDto.getReservationTime());
            existingReservation.setStatus(reservationRequestDto.getStatus());
            return reservationRepository.save(existingReservation);
        }
        return null;
    }
    
    public Reservation addReservation(ReservationRequestDto reservationRequestDto) {
        Reservation reservation = new Reservation();
        reservation.setUserId(reservationRequestDto.getUserId());
        reservation.setMovieId(reservationRequestDto.getMovieId());
        reservation.setReservationTime(reservationRequestDto.getReservationTime());
        reservation.setStatus(reservationRequestDto.getStatus());
        return reservationRepository.save(reservation);
    }
}
