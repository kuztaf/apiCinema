package com.cinema.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDateTime;
import com.cinema.cinema.types.ReservationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Showtime showtime;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationStatusEnum status;
}
