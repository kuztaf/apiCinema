package com.cinema.cinema.dto;

import java.time.LocalDateTime;

import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.entity.Room;

public record ShowtimeRequestDto(
                Movie movie,
                Room room,
                LocalDateTime startTime,
                LocalDateTime endTime) {
}
