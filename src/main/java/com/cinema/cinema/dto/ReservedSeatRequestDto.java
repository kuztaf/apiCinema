package com.cinema.cinema.dto;

import com.cinema.cinema.entity.Reservation;
import com.cinema.cinema.entity.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservedSeatRequestDto {
    private Reservation reservation;
    private Seat seat;
}
