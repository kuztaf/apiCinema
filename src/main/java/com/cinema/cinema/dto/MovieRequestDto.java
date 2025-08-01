package com.cinema.cinema.dto;

import com.cinema.cinema.types.MovieGenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDto {

    private String title;
    private int duration;
    private MovieGenderEnum gender;
    private String description;
    private String posterUrl;


}
