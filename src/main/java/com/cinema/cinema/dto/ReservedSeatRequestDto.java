package com.cinema.cinema.dto;

import com.cinema.cinema.entity.Reservation;
import com.cinema.cinema.entity.Seat;
import com.cinema.cinema.types.ReservedSeatStatusEnum;

public record ReservedSeatRequestDto(Reservation reservation, Seat seat, ReservedSeatStatusEnum status) {
}
