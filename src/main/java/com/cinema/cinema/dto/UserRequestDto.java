package com.cinema.cinema.dto;

import com.cinema.cinema.types.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String name;
    private String email;
    private String password;
    private RoleEnum role; // e.g., "USER", "ADMIN"
}
