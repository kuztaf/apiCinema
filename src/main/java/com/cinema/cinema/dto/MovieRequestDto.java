package com.cinema.cinema.dto;

import com.cinema.cinema.types.MovieGenderEnum;

public record MovieRequestDto(
                String title,
                int duration,
                MovieGenderEnum gender,
                String description,
                String posterUrl) {
}
