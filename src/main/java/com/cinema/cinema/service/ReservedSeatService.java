package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.ReservedSeatRequestDto;
import com.cinema.cinema.entity.ReservedSeat;
import com.cinema.cinema.repository.ReservedSeatRepository;

@Service
public class ReservedSeatService {

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    public List<ReservedSeat> getAllReservedSeats() {
        return reservedSeatRepository.findAll();
    }

    public ReservedSeat getReservedSeatById(int id) {
        return reservedSeatRepository.findById(id).orElse(null);
    }

    public ReservedSeat deleteReservedSeatById(int id) {
        ReservedSeat reservedSeat = getReservedSeatById(id);
        if (reservedSeat != null) {
            reservedSeatRepository.delete(reservedSeat);
            return reservedSeat;
        }
        return null;
    }

    public ReservedSeat updateReservedSeat(int id, ReservedSeatRequestDto reservedSeatRequestDto) {
        ReservedSeat existingReservedSeat = getReservedSeatById(id);
        if (existingReservedSeat != null) {
            existingReservedSeat.setReservation(reservedSeatRequestDto.reservation());
            existingReservedSeat.setSeat(reservedSeatRequestDto.seat());
            existingReservedSeat.setStatus(reservedSeatRequestDto.status());
            return reservedSeatRepository.save(existingReservedSeat);
        }
        return null;
    }

    public ReservedSeat addReservedSeat(ReservedSeatRequestDto reservedSeatRequestDto) {
        ReservedSeat reservedSeat = new ReservedSeat();
        reservedSeat.setReservation(reservedSeatRequestDto.reservation());
        reservedSeat.setSeat(reservedSeatRequestDto.seat());
        reservedSeat.setStatus(reservedSeatRequestDto.status());
        return reservedSeatRepository.save(reservedSeat);
    }

}
