package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.SeatRequestDto;
import com.cinema.cinema.entity.Seat;
import com.cinema.cinema.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(int id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat deleteSeatById(int id) {
        Seat seat = getSeatById(id);
        if (seat != null) {
            seatRepository.delete(seat);
            return seat;
        }
        return null;
    }

    public Seat updateSeat(int id, SeatRequestDto seatRequestDto) {
        Seat existingSeat = getSeatById(id);
        if (existingSeat != null) {
            existingSeat.setRow(seatRequestDto.getRow());
            existingSeat.setColumn(seatRequestDto.getColumn());
            existingSeat.setRoom(seatRequestDto.getRoom());
            return seatRepository.save(existingSeat);
        }
        return null;
    }

    public Seat addSeat(SeatRequestDto seatRequestDto) {
        Seat seat = new Seat();
        seat.setRow(seatRequestDto.getRow());
        seat.setColumn(seatRequestDto.getColumn());
        seat.setRoom(seatRequestDto.getRoom());
        return seatRepository.save(seat);
    }

}
