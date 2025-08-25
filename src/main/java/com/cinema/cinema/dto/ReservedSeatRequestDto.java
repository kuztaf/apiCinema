package com.cinema.cinema.dto;

import com.cinema.cinema.entity.Reservation;
import com.cinema.cinema.entity.Seat;

public record ReservedSeatRequestDto(Reservation reservation, Seat seat) {
}
