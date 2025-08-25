package com.cinema.cinema.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Showtime {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @NotNull
    @ManyToOne
    private Movie movie;
    @NotNull
    @ManyToOne
    private Room room;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startTime;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime endTime;

}
