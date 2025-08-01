package com.cinema.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema.cinema.dto.ReservationRequestDto;
import com.cinema.cinema.entity.Reservation;
import com.cinema.cinema.service.ReservationService;



@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservationById(@PathVariable int id) {
        Reservation deletedReservation = reservationService.deleteReservationById(id);
        if (deletedReservation != null) {
            return ResponseEntity.ok(deletedReservation);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable int id, @RequestBody ReservationRequestDto reservationRequestDto) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservationRequestDto);
        if (updatedReservation != null) {
            return ResponseEntity.ok(updatedReservation);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Reservation> addReservation(@PathVariable int id, @RequestBody ReservationRequestDto reservationRequestDto) {
        Reservation newReservation = reservationService.addReservation(reservationRequestDto);
        if (newReservation != null) {
            return ResponseEntity.status(201).body(newReservation);
        }
        return ResponseEntity.badRequest().build();
    }

}
