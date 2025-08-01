package com.cinema.cinema.dto;

import java.time.LocalDateTime;

import com.cinema.cinema.types.ReservationStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDto {
   
    private int userId;
    private int movieId;
    private LocalDateTime reservationTime;
    private ReservationStatusEnum status;
}
