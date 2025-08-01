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

import com.cinema.cinema.dto.SeatRequestDto;
import com.cinema.cinema.entity.Seat;
import com.cinema.cinema.service.SeatService;



@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;


    @GetMapping("/")
    public ResponseEntity<List<Seat>> getAllSeat() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        Seat seat = seatService.getSeatById(id);
        if (seat != null) {
            return ResponseEntity.ok(seat);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Seat> deleteSeatById(@PathVariable int id) {
        Seat seat = seatService.deleteSeatById(id);
        if (seat != null) {
            return ResponseEntity.ok(seat);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable int id, @RequestBody SeatRequestDto seatRequestDto) {
        Seat updatedSeat = seatService.updateSeat(id, seatRequestDto);
        if (updatedSeat != null) {
            return ResponseEntity.ok(updatedSeat);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Seat> addSeat(@RequestBody SeatRequestDto seatRequestDto) {
        Seat newSeat = seatService.addSeat(seatRequestDto);
        if (newSeat != null) {
            return ResponseEntity.status(201).body(newSeat);
        }
        return ResponseEntity.badRequest().build();
    }
}
