package com.cinema.cinema.entity;

import com.cinema.cinema.types.MovieGenderEnum;
import org.junit.jupiter.api.Test;
import com.cinema.cinema.util.TestMovieFactory;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testMovieConstructorAndGetters() {
        Movie movie = TestMovieFactory.createTestValidMovie();
        assertEquals(0, movie.getId());
        assertEquals("Matrix", movie.getTitle());
        assertEquals(120, movie.getDuration());
        assertEquals(MovieGenderEnum.ACTION, movie.getGender());
        assertEquals("A sci-fi movie", movie.getDescription());
        assertEquals("http://poster.url/matrix.jpg", movie.getPosterUrl());
    }

    @Test
    void testSetters() {
        Movie movie = TestMovieFactory.createTestEmptyObject();
        movie.setId(2);
        movie.setTitle("Titanic");
        movie.setDuration(195);
        movie.setGender(MovieGenderEnum.DRAMA);
        movie.setDescription("A romantic drama");
        movie.setPosterUrl("http://poster.url/titanic.jpg");

        assertEquals(2, movie.getId());
        assertEquals("Titanic", movie.getTitle());
        assertEquals(195, movie.getDuration());
        assertEquals(MovieGenderEnum.DRAMA, movie.getGender());
        assertEquals("A romantic drama", movie.getDescription());
        assertEquals("http://poster.url/titanic.jpg", movie.getPosterUrl());
    }

    @Test
    void testNoArgsConstructor() {
        Movie movie = TestMovieFactory.createTestEmptyObject();
        assertNotNull(movie);
    }

    @Test
    void testAllArgsConstructor() {
        Movie movie = TestMovieFactory.createTestMovieWithArgs(3, "Avatar", 162, MovieGenderEnum.ACTION,
                "Epic science fiction",
                "http://poster.url/avatar.jpg");
        assertEquals(3, movie.getId());
        assertEquals("Avatar", movie.getTitle());
        assertEquals(162, movie.getDuration());
        assertEquals(MovieGenderEnum.ACTION, movie.getGender());
        assertEquals("Epic science fiction", movie.getDescription());
        assertEquals("http://poster.url/avatar.jpg", movie.getPosterUrl());
    }

    @Test
    void testEnumToString() {

        Movie movie = TestMovieFactory.createTestValidMovie();
        assertEquals(movie.getGender().getDisplayName(), "Action");

    }

}
