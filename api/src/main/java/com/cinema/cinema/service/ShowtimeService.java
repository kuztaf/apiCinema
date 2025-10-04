package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.ShowtimeRequestDto;
import com.cinema.cinema.entity.Showtime;
import com.cinema.cinema.repository.ShowtimeRepository;

@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime getShowtimeById(int id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    public Showtime deleteShowtimeById(int id) {
        Showtime showtime = getShowtimeById(id);
        if (showtime != null) {
            showtimeRepository.delete(showtime);
        }
        return showtime;
    }

    public Showtime updateShowtime(int id, ShowtimeRequestDto showtimeRequestDto) {
        Showtime existingShowtime = getShowtimeById(id);
        if (existingShowtime != null) {
            existingShowtime.setMovie(showtimeRequestDto.movie());
            existingShowtime.setRoom(showtimeRequestDto.room());
            existingShowtime.setStartTime(showtimeRequestDto.startTime());
            existingShowtime.setEndTime(showtimeRequestDto.endTime());
            return showtimeRepository.save(existingShowtime);
        }
        return null;
    }

    public Showtime addShowtime(ShowtimeRequestDto showtimeRequestDto) {
        Showtime newShowtime = Showtime.builder()
                .movie(showtimeRequestDto.movie())
                .room(showtimeRequestDto.room())
                .startTime(showtimeRequestDto.startTime())
                .endTime(showtimeRequestDto.endTime())
                .build();
        return showtimeRepository.save(newShowtime);
    }
}
