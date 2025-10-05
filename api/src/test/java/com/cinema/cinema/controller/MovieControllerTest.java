package com.cinema.cinema.controller;

import com.cinema.cinema.dto.MovieRequestDto;
import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.service.MovieService;
import com.cinema.cinema.util.TestMovieFactory;
import com.cinema.cinema.util.TestMovieRequestDtoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
@AutoConfigureMockMvc(addFilters = false)
class MovieControllerTest {

        private final MockMvc mockMvc;


        @MockitoBean
        private MovieService movieService;

        private final ObjectMapper objectMapper; // para convertir objetos a JSON

        private final String baseMoviesEndpoint = "/movies";

        @Autowired
        public MovieControllerTest(MockMvc mockMvc, MovieService movieService, ObjectMapper objectMapper) {
                this.mockMvc = mockMvc;
                this.movieService = movieService;
                this.objectMapper = objectMapper;
        }

      
        @Test
        @DisplayName("Should return all movies when calling GET /movies/")
        void testGetAllMovies() throws Exception {
                Movie m1 = TestMovieFactory.createTestComedyMovie();
                Movie m2 = TestMovieFactory.createTestDramaMovie();
                Movie m3 = TestMovieFactory.createTestRomanticMovie();
                String moviesGetAllEndpoint = baseMoviesEndpoint + "/";
                List<Movie> movieList = Arrays.asList(m1, m2, m3);

                when(movieService.getAllMovies()).thenReturn(movieList);
                mockMvc.perform(get(moviesGetAllEndpoint))
                                                .andExpect(status().isOk())
                                                .andExpect(jsonPath("$.length()").value(movieList.size()))
                                                .andExpect(jsonPath("$[0].title").value(m1.getTitle()))
                                                .andExpect(jsonPath("$[1].title").value(m2.getTitle()))
                                                .andExpect(jsonPath("$[2].title").value(m3.getTitle()));
        }

        @Test
        @DisplayName("Should return the movie details when calling GET /movies/{id}")
        void testGetMovieById() throws Exception {
                int idMovieToGet = 1;
                String moviesGetByIdEndpoint = baseMoviesEndpoint + "/" + idMovieToGet;
                Movie movie = TestMovieFactory.createTestValidMovie();

                when(movieService.getMovieById(idMovieToGet)).thenReturn(movie);

                mockMvc.perform(get(moviesGetByIdEndpoint))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value(movie.getTitle()))
                                .andExpect(jsonPath("$.duration").value(movie.getDuration()));
        }

        @Test
        @DisplayName("Should create a new movie when calling POST /movies/")
        void testAddMovie() throws Exception {
                MovieRequestDto request = TestMovieRequestDtoFactory.createRomanticMovieRequest();
                String moviesAddEndpoint = baseMoviesEndpoint + "/";
                Movie saved = TestMovieFactory.createTestRomanticMovie();

                when(movieService.addMovie(any(MovieRequestDto.class))).thenReturn(saved);

                mockMvc.perform(post(moviesAddEndpoint)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.title").value(request.title()))
                                .andExpect(jsonPath("$.duration").value(request.duration()))
                                .andExpect(jsonPath("$.gender").value(request.gender().name()))
                                .andExpect(jsonPath("$.id").value(0));
        }

        @Test
        @DisplayName("Should update a movie when calling PUT /movies/{id}")
        void testUpdateMovie() throws Exception {
                MovieRequestDto request = TestMovieRequestDtoFactory.createValidMovieRequest();
                int idMovieToUpdate = 1;
                Movie updated = TestMovieFactory.createTestValidMovie();
                String moviesUpdateEndpoint = baseMoviesEndpoint + "/" + idMovieToUpdate;

                when(movieService.updateMovie(eq(idMovieToUpdate), any(MovieRequestDto.class))).thenReturn(updated);

                mockMvc.perform(put(moviesUpdateEndpoint)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("Matrix"))
                                .andExpect(jsonPath("$.duration").value(120));
        }

        @Test
        @DisplayName("Should delete a movie when calling DELETE /movies/{id}")
        void testDeleteMovie() throws Exception {
                Movie deleted = TestMovieFactory.createTestComedyMovie();
                int idMovieToDelete = 1;
                String moviesDeleteEndpoint = baseMoviesEndpoint + "/" + idMovieToDelete;
                when(movieService.deleteMovieById(idMovieToDelete)).thenReturn(deleted);

                mockMvc.perform(delete(moviesDeleteEndpoint))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value(deleted.getTitle()));
        }
}