
package com.cinema.cinema.entity;

import com.cinema.cinema.types.MovieGenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true, length = 200)
    private String title;

    // Duration of the movie in minutes
    @Min(1)
    @Max(500)
    @NotNull
    @Column(nullable = false)
    private int duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieGenderEnum gender;

    @Size(max = 500)
    private String description;

    @Size(max = 255)
    private String posterUrl;

}
