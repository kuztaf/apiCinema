package com.cinema.cinema.dto;

import java.time.LocalDateTime;

import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.entity.Room;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowtimeRequestDto {
        @ManyToOne
        private Movie movie;
        @ManyToOne
        private Room room;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

}
