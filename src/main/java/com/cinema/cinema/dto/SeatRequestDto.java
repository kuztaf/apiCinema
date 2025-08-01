package com.cinema.cinema.dto;

import com.cinema.cinema.entity.Room;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequestDto {

    private int row;
    private int column;
    @ManyToOne
    private Room room;
}
