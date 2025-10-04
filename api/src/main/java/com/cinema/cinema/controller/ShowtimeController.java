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

import com.cinema.cinema.dto.ShowtimeRequestDto;
import com.cinema.cinema.entity.Showtime;
import com.cinema.cinema.service.ShowtimeService;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        List<Showtime> showtimes = showtimeService.getAllShowtimes();
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable int id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        if (showtime != null) {
            return ResponseEntity.ok(showtime);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Showtime> deleteShowtimeById(@PathVariable int id) {
        Showtime deletedShowtime = showtimeService.deleteShowtimeById(id);
        if (deletedShowtime != null) {
            return ResponseEntity.ok(deletedShowtime);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable int id,
            @RequestBody ShowtimeRequestDto showtimeRequestDto) {
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtimeRequestDto);
        if (updatedShowtime != null) {
            return ResponseEntity.ok(updatedShowtime);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Showtime> addShowtime(@RequestBody ShowtimeRequestDto showtimeRequestDto) {
        Showtime newShowtime = showtimeService.addShowtime(showtimeRequestDto);
        if (newShowtime != null) {
            return ResponseEntity.status(201).body(newShowtime);
        }
        return ResponseEntity.badRequest().build();
    }

}
