package com.cinema.cinema.entity;

import java.time.LocalDateTime;

import com.cinema.cinema.types.ReservationStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int id;
    private int userId;
    private int movieId;
    private LocalDateTime reservationTime;
    private ReservationStatusEnum status;
}
