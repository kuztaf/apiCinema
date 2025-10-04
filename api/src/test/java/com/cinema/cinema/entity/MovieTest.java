package com.cinema.cinema.entity;


import com.cinema.cinema.types.MovieGenderEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import com.cinema.cinema.util.TestMovieFactory;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {


    @Nested
    @DisplayName("Constructor and Getter Tests")
    class ConstructorAndGetterTests {
    

        @Test
        @DisplayName("Should create Movie with valid data and verify getters")
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
        @DisplayName("Should set all Movie fields using setters and verify values")
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
        @DisplayName("Should create Movie using all-args constructor and verify values")
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

   
    }

    @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {
        @Test
        @DisplayName("Should create Movie using no-args constructor")
        void testNoArgsConstructor() {
            Movie movie = TestMovieFactory.createTestEmptyObject();
            assertNotNull(movie);
        }

         @Test
        @DisplayName("Should create Movie using no-args constructor")
        void testMinDuration() {
            int minDuration = 1;
            Movie movie = TestMovieFactory.createTestMovieWithMinDuration();
            assertEquals(minDuration, movie.getDuration());
        }

        @Test
        @DisplayName("Should create Movie with a long duration")
        void testLongDuration() {
            Movie movie = TestMovieFactory.createTestRomanticMovie();
            assertTrue(movie.isLongMovie());
        }

    }

    @Nested
    @DisplayName("ToString Cases Tests")
    class ToStringCasesTests {
        @Test
        @DisplayName("Should return correct display name for MovieGenderEnum")
        void testEnumToString() {

            Movie movie = TestMovieFactory.createTestValidMovie();
            assertEquals(movie.getGender().getDisplayName(), "Action");

        }

        @Test
        @DisplayName("Should return correct summary string")
        void testGetSummary() {
            Movie movie = TestMovieFactory.createTestValidMovie();
            String expectedSummary = movie.getTitle() + " (" + movie.getDuration() + " min) - " + movie.getDescription();
            assertEquals(expectedSummary, movie.getSummary());

        }
    }
}
