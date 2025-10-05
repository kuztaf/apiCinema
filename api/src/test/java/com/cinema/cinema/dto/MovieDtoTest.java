package com.cinema.cinema.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import com.cinema.cinema.types.MovieGenderEnum;
import com.cinema.cinema.util.TestMovieRequestDtoFactory;

public class MovieDtoTest {

    @Nested
    @DisplayName("Constructor and Getter Tests")
    class ConstructorAndGetterTests {
 
        @Test
        @DisplayName("Should create MovieRequestDto using factory and verify all field values match expected data")
        void testRecordValues() {
            // Arrange
            String title = "Matrix";
            int duration = 120;
            MovieGenderEnum gender = MovieGenderEnum.ACTION;
            String description = "A sci-fi movie";
            String posterUrl = "http://poster.url/matrix.jpg";

            // Act
            MovieRequestDto movieDto = TestMovieRequestDtoFactory.createValidMovieRequest();
            
            // Assert
            assertEquals(title, movieDto.title());
            assertEquals(duration, movieDto.duration());
            assertEquals(gender, movieDto.gender());
            assertEquals(description, movieDto.description());
            assertEquals(posterUrl, movieDto.posterUrl());
        }

  
        @Test
        @DisplayName("Should create MovieRequestDto with null values using factory and handle them correctly")
        void testEmptyValues() {
            MovieRequestDto dto = TestMovieRequestDtoFactory.createNullMovieRequest();

            assertEquals(null, dto.title());
            assertEquals(0, dto.duration());
            assertEquals(null, dto.gender());
            assertEquals(null, dto.description());
            assertEquals(null, dto.posterUrl());
        }
    }
  @Nested
    @DisplayName("Edge Cases Tests")
    class EdgeCasesTests {

        @Test
        @DisplayName("Should handle minimum duration")
        void shouldHandleMinimumDuration() {
            // Given
            MovieRequestDto dto = TestMovieRequestDtoFactory.createMovieWithMinimumDuration();

            // Then
            assertEquals(1, dto.duration());
        }

        @Test
        @DisplayName("Should handle long title")
        void shouldHandleLongTitle() {
            // Given
            String longTitle = "This is a very long movie title that exceeds normal length expectations for testing purposes";
            MovieRequestDto dto = TestMovieRequestDtoFactory.createMovieWithLongTitle();

            // Then
            assertEquals(longTitle, dto.title());
        }

        @Test
        @DisplayName("Should handle empty description")
        void shouldHandleEmptyDescription() {
            // Given
            MovieRequestDto dto = TestMovieRequestDtoFactory.createEmptyMovieRequest();

            // Then
            assertEquals("", dto.description());
        }

        @Test
        @DisplayName("Should handle null values")
        void shouldHandleNullValues() {
            // Given/When
            MovieRequestDto dto = TestMovieRequestDtoFactory.createNullMovieRequest();

            // Then
            assertEquals(null, dto.title());
            assertEquals(0, dto.duration());
            assertEquals(null, dto.gender());
            assertEquals(null, dto.description());
            assertEquals(null, dto.posterUrl());
        }
    }


     @Nested
    @DisplayName("Equality and HashCode Tests")
    class EqualityAndHashCodeTests {

      @Test
        @DisplayName("Should create identical MovieRequestDto objects using factory and verify equals and hashCode")
        void testEqualsAndHashCode() {
            MovieRequestDto dto1 = TestMovieRequestDtoFactory.createValidMovieRequest();
            MovieRequestDto dto2 = TestMovieRequestDtoFactory.createValidMovieRequest();

            assertEquals(dto1, dto2);
            assertEquals(dto1.hashCode(), dto2.hashCode());
        }

        @Test
        @DisplayName("Should not be equal when duration is differ")
        void shouldNotBeEqualWhenDurationIsDiffer() {
            // Given
            MovieRequestDto dto1 = TestMovieRequestDtoFactory.createMovieWithInvalidDuration();
            MovieRequestDto dto2 =TestMovieRequestDtoFactory.createMovieWithMinimumDuration();
            
            // Then
            assertEquals(false, dto1.equals(dto2));
        }

    }

    @Nested
    @DisplayName("Different Movie Genres Tests")
    class DifferentMovieGenresTests {

        @Test
        @DisplayName("Should handle all movie genres")
        void shouldHandleAllMovieGenres() {
            // Test each enum value
            for (MovieGenderEnum gender : MovieGenderEnum.values()) {
                MovieRequestDto movieRequestDto = new MovieRequestDto(
                        "Test Movie",
                        100,
                        gender,
                        "Test description",
                        "http://test.url"
                );

                assertEquals(gender, movieRequestDto.gender());
            }
        }
    }

}
