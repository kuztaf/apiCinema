package com.cinema.cinema.dto;

import java.time.LocalDateTime;

import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.entity.User;
import com.cinema.cinema.types.ReservationStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
   
    private User user;
    private Movie movie;
    private LocalDateTime reservationTime;
    private ReservationStatusEnum status;
}
