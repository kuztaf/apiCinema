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

import com.cinema.cinema.dto.ReservedSeatRequestDto;
import com.cinema.cinema.entity.ReservedSeat;
import com.cinema.cinema.service.ReservedSeatService;

@RestController
@RequestMapping("/reserved-seats")
public class ReservedSeatController {

    @Autowired
    private ReservedSeatService reservedSeatService;

    @GetMapping("/")
    public ResponseEntity<List<ReservedSeat>> getAllReservedSeats() {
        List<ReservedSeat> reservedSeats = reservedSeatService.getAllReservedSeats();
        return ResponseEntity.ok(reservedSeats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservedSeat> getReservedSeatById(@PathVariable int id) {
        ReservedSeat reservedSeat = reservedSeatService.getReservedSeatById(id);
        if (reservedSeat != null) {
            return ResponseEntity.ok(reservedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservedSeat> deleteReservedSeatById(@PathVariable int id) {
        ReservedSeat deletedReservedSeat = reservedSeatService.deleteReservedSeatById(id);
        if (deletedReservedSeat != null) {
            return ResponseEntity.ok(deletedReservedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservedSeat> updateReservedSeat(@PathVariable int id, @RequestBody ReservedSeatRequestDto reservedSeatRequestDto) {
        ReservedSeat updatedReservedSeat = reservedSeatService.updateReservedSeat(id, reservedSeatRequestDto);
        if (updatedReservedSeat != null) {
            return ResponseEntity.ok(updatedReservedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<ReservedSeat> addReservedSeat(@PathVariable int id, @RequestBody ReservedSeatRequestDto reservedSeatRequestDto) {
        ReservedSeat newReservedSeat = reservedSeatService.addReservedSeat(reservedSeatRequestDto);
        if (newReservedSeat != null) {
            return ResponseEntity.status(201).body(newReservedSeat);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}