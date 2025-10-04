package com.cinema.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.cinema.dto.MovieRequestDto;
import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

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
        Movie movie = Movie.builder()
                .title(movieRequestDto.title())
                .duration(movieRequestDto.duration())
                .gender(movieRequestDto.gender())
                .description(movieRequestDto.description())
                .posterUrl(movieRequestDto.posterUrl())
                .build();
        return movieRepository.save(movie);
    }

}
