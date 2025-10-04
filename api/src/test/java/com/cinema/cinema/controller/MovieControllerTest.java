package com.cinema.cinema.controller;

import com.cinema.cinema.dto.MovieRequestDto;
import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.service.MovieService;
import com.cinema.cinema.util.TestMovieFactory;
import com.cinema.cinema.util.TestMovieRequestDtoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class) // solo carga el controller
class MovieControllerTest {

        private final MockMvc mockMvc;

        @MockitoBean
        private MovieService movieService;

        private final ObjectMapper objectMapper; // para convertir objetos a JSON

        @Autowired
        public MovieControllerTest(MockMvc mockMvc, MovieService movieService, ObjectMapper objectMapper) {
                this.mockMvc = mockMvc;
                this.movieService = movieService;
                this.objectMapper = objectMapper;
        }

        @Test
        void testGetAllMovies() throws Exception {
                Movie m1 = TestMovieFactory.createTestComedyMovie();
                Movie m2 = TestMovieFactory.createTestDramaMovie();

                when(movieService.getAllMovies()).thenReturn(Arrays.asList(m1, m2));

                mockMvc.perform(get("/movies/"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.length()").value(2))
                                .andExpect(jsonPath("$[0].title").value("The Mask"))
                                .andExpect(jsonPath("$[1].title").value("The Shawshank Redemption"));
        }

        @Test
        void testGetMovieById() throws Exception {
                Movie movie = TestMovieFactory.createTestValidMovie();

                when(movieService.getMovieById(1)).thenReturn(movie);

                mockMvc.perform(get("/movies/1"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("Matrix"))
                                .andExpect(jsonPath("$.duration").value(120));
        }

        @Test
        void testAddMovie() throws Exception {
                MovieRequestDto request = TestMovieRequestDtoFactory.createRomanticMovieRequest();

                Movie saved = TestMovieFactory.createTestRomanticMovie();

                when(movieService.addMovie(any(MovieRequestDto.class))).thenReturn(saved);

                mockMvc.perform(post("/movies/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.title").value("Titanic"))
                                .andExpect(jsonPath("$.id").value(0));
        }

        @Test
        void testUpdateMovie() throws Exception {
                MovieRequestDto request = TestMovieRequestDtoFactory.createValidMovieRequest();
                Movie updated = TestMovieFactory.createTestValidMovie();

                when(movieService.updateMovie(eq(1), any(MovieRequestDto.class))).thenReturn(updated);

                mockMvc.perform(put("/movies/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("Matrix"))
                                .andExpect(jsonPath("$.duration").value(120));
        }

        @Test
        void testDeleteMovie() throws Exception {
                Movie deleted = TestMovieFactory.createTestComedyMovie();

                when(movieService.deleteMovieById(1)).thenReturn(deleted);

                mockMvc.perform(delete("/movies/1"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title").value("The Mask"));
        }
}