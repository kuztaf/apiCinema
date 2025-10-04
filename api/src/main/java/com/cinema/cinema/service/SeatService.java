package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.SeatRequestDto;
import com.cinema.cinema.entity.Seat;
import com.cinema.cinema.repository.SeatRepository;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

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
            existingSeat.setSeatRow(seatRequestDto.row());
            existingSeat.setSeatColumn(seatRequestDto.column());
            existingSeat.setRoom(seatRequestDto.room());
            return seatRepository.save(existingSeat);
        }
        return null;
    }

    public Seat addSeat(SeatRequestDto seatRequestDto) {
        Seat seat = Seat.builder()
                .seatRow(seatRequestDto.row())
                .seatColumn(seatRequestDto.column())
                .room(seatRequestDto.room())
                .build();
        return seatRepository.save(seat);
    }

}
