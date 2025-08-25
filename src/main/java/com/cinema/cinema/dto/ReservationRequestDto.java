package com.cinema.cinema.dto;

import java.time.LocalDateTime;

import com.cinema.cinema.entity.Showtime;
import com.cinema.cinema.entity.User;
import com.cinema.cinema.types.ReservationStatusEnum;

public record ReservationRequestDto(
        User user,
        Showtime showtime,
        LocalDateTime reservationTime,
        ReservationStatusEnum status) {
}
