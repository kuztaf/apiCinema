package com.cinema.cinema.dto;

import com.cinema.cinema.types.RoleEnum;

public record UserRequestDto(
        String name,
        String email,
        String password,
        RoleEnum role // e.g., "USER", "ADMIN"
) {
}
