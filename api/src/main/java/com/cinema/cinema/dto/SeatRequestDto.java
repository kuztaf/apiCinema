package com.cinema.cinema.dto;

import com.cinema.cinema.entity.Room;

public record SeatRequestDto(int row, int column, Room room) {
}
