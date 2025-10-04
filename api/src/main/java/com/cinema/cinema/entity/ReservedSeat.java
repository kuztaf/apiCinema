package com.cinema.cinema.entity;

import com.cinema.cinema.types.ReservedSeatStatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ReservedSeat {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    @NotNull
    @ManyToOne
    private Reservation reservation;
    @NotNull
    @ManyToOne
    private Seat seat;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservedSeatStatusEnum status;
}
