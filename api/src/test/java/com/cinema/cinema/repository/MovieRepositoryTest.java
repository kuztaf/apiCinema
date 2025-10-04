package com.cinema.cinema.repository;

import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.util.TestMovieFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // arranca solo la capa de persistencia con H2 en memoria
class MovieRepositoryTest {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieRepositoryTest(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Test
    void testSaveAndFindById() {
        Movie movie = TestMovieFactory.createTestValidMovie();

        Movie saved = movieRepository.save(movie);

        Optional<Movie> found = movieRepository.findById(saved.getId());
        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Matrix");
    }

    @Test
    void testFindAll() {
        Movie movie1 = TestMovieFactory.createTestComedyMovie();
        Movie movie2 = TestMovieFactory.createTestDramaMovie();

        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<Movie> movies = movieRepository.findAll();
        assertThat(movies).hasSize(2);
    }

    @Test
    void testDelete() {
        Movie movie = TestMovieFactory.createTestValidMovie();

        Movie saved = movieRepository.save(movie);
        movieRepository.deleteById(saved.getId());

        Optional<Movie> deleted = movieRepository.findById(saved.getId());
        assertThat(deleted).isEmpty();
    }
}