package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.MovieRequestDto;
import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie deleteMovieById(int id) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movieRepository.delete(movie);
            return movie;
        }
        return null;
    }

    public Movie updateMovie(int id, MovieRequestDto movie) {
        Movie existingMovie = getMovieById(id);
        if (existingMovie != null) {
            existingMovie.setTitle(movie.title());
            existingMovie.setGender(movie.gender());
            existingMovie.setDuration(movie.duration());
            existingMovie.setDescription(movie.description());
            existingMovie.setPosterUrl(movie.posterUrl());
            return movieRepository.save(existingMovie);
        }
        return null;
    }

    public Movie addMovie(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.title());
        movie.setDuration(movieRequestDto.duration());
        movie.setGender(movieRequestDto.gender());
        movie.setDescription(movieRequestDto.description());
        movie.setPosterUrl(movieRequestDto.posterUrl());
        return movieRepository.save(movie);

    }

}
