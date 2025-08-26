package com.cinema.cinema.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.ReservedSeatRequestDto;
import com.cinema.cinema.entity.ReservedSeat;
import com.cinema.cinema.repository.ReservedSeatRepository;
import com.cinema.cinema.types.ReservationStatusEnum;
import com.cinema.cinema.types.ReservedSeatStatusEnum;

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

    public List<ReservedSeat> getAllReservedSeatsByReservation(int reservationId) {
        return reservedSeatRepository.findAllByReservationId(reservationId);
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

    public List<ReservedSeat> addReservedListSeats(List<ReservedSeatRequestDto> reservedListSeatRequestDtos) {
        List<ReservedSeat> reservedSeats = new ArrayList<>();
        for (ReservedSeatRequestDto dto : reservedListSeatRequestDtos) {
            ReservedSeat reservedSeat = ReservedSeat.builder()
                    .reservation(dto.reservation())
                    .seat(dto.seat())
                    .status(dto.status())
                    .build();
            reservedSeats.add(reservedSeat);
        }
        return reservedSeatRepository.saveAll(reservedSeats);
    }

    public List<ReservedSeat> handleReservedSeat(int id, ReservationStatusEnum status) {

        List<ReservedSeat> existingReservedSeats = getAllReservedSeatsByReservation(id);
        if (existingReservedSeats == null || existingReservedSeats.isEmpty()) {
            return new ArrayList<>();
        }
        if (status == ReservationStatusEnum.CONFIRMED) {
            // Handle confirmed status
            ReservedSeatStatusEnum newStatus = ReservedSeatStatusEnum.CONFIRMED;
            existingReservedSeats.forEach(seat -> seat.setStatus(newStatus));
            return reservedSeatRepository.saveAll(existingReservedSeats);

        } else if (status == ReservationStatusEnum.CANCELLED) {
            // Handle cancelled status
            reservedSeatRepository.deleteAll(existingReservedSeats);
            return new ArrayList<>();
        }

        return new ArrayList<>();
    }

}
