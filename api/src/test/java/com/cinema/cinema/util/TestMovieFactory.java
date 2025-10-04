package com.cinema.cinema.util;

import com.cinema.cinema.entity.Movie;
import com.cinema.cinema.types.MovieGenderEnum;

public class TestMovieFactory {

    public static Movie createTestValidMovie() {
        return Movie.builder()
                .title("Matrix")
                .duration(120)
                .gender(MovieGenderEnum.ACTION)
                .description("A sci-fi movie")
                .posterUrl("http://poster.url/matrix.jpg")
                .build();
    }

    public static Movie createTestComedyMovie() {
        return Movie.builder()
                .title("The Mask")
                .duration(101)
                .gender(MovieGenderEnum.COMEDY)
                .description("A comedy movie")
                .posterUrl("http://poster.url/themask.jpg")
                .build();
    }

    public static Movie createTestDramaMovie() {
        return Movie.builder()
                .title("The Shawshank Redemption")
                .duration(142)
                .gender(MovieGenderEnum.DRAMA)
                .description("A drama movie")
                .posterUrl("http://poster.url/shawshank.jpg")
                .build();
    }

    public static Movie createTestRomanticMovie() {
        return Movie.builder()
                .title("Titanic")
                .duration(195)
                .gender(MovieGenderEnum.ROMANCE)
                .description("Romantic drama")
                .posterUrl("http://poster.url/titanic.jpg")
                .build();
    }

    public static Movie createTestMovieWithNullDescription() {
        return Movie.builder()
                .title("No Description")
                .duration(90)
                .gender(MovieGenderEnum.ACTION)
                .description(null)
                .posterUrl("http://poster.url/nodesc.jpg")
                .build();
    }

    public static Movie createTestMovieWithInvalidDuration() {
        return Movie.builder()
                .title("Short Movie")
                .duration(-10)
                .gender(MovieGenderEnum.ACTION)
                .description("Invalid duration")
                .posterUrl("http://poster.url/short.jpg")
                .build();
    }

    public static Movie createTestEmptyObject() {
        return new Movie();
    }

    public static Movie createTestMovieWithArgs(int id, String title, int duration, MovieGenderEnum gender,
            String description, String posterUrl) {
        return new Movie(id, title, duration, gender, description, posterUrl);
    }
}
