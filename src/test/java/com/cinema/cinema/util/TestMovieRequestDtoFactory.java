package com.cinema.cinema.util;

import com.cinema.cinema.dto.MovieRequestDto;
import com.cinema.cinema.types.MovieGenderEnum;

public class TestMovieRequestDtoFactory {

    public static MovieRequestDto createValidMovieRequest() {
        return new MovieRequestDto(
                "Matrix",
                120,
                MovieGenderEnum.ACTION,
                "A sci-fi movie",
                "http://poster.url/matrix.jpg");
    }

    public static MovieRequestDto createComedyMovieRequest() {
        return new MovieRequestDto(
                "The Mask",
                101,
                MovieGenderEnum.COMEDY,
                "A comedy movie",
                "http://poster.url/themask.jpg");
    }

    public static MovieRequestDto createDramaMovieRequest() {
        return new MovieRequestDto(
                "The Shawshank Redemption",
                142,
                MovieGenderEnum.DRAMA,
                "A drama movie",
                "http://poster.url/shawshank.jpg");
    }

    public static MovieRequestDto createRomanticMovieRequest() {
        return new MovieRequestDto(
                "Titanic",
                195,
                MovieGenderEnum.ROMANCE,
                "Romantic drama",
                "http://poster.url/titanic.jpg");
    }

    public static MovieRequestDto createMovieWithNullDescription() {
        return new MovieRequestDto(
                "No Description",
                90,
                MovieGenderEnum.ACTION,
                null,
                "http://poster.url/nodesc.jpg");
    }

    public static MovieRequestDto createMovieWithInvalidDuration() {
        return new MovieRequestDto(
                "Short Movie",
                -10,
                MovieGenderEnum.ACTION,
                "Invalid duration",
                "http://poster.url/short.jpg");
    }

    public static MovieRequestDto createEmptyMovieRequest() {
        return new MovieRequestDto(
                null,
                0,
                null,
                null,
                null);
    }

    public static MovieRequestDto createCustomMovieRequest(String title, int duration, MovieGenderEnum gender,
            String description, String posterUrl) {
        return new MovieRequestDto(title, duration, gender, description, posterUrl);
    }
}
