package com.cinema.cinema.types;

public enum MovieGenderEnum {

    ACTION("Action"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    HORROR("Horror"),
    THRILLER("Thriller"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science Fiction"),
    FANTASY("Fantasy"),
    ANIMATION("Animation"),
    DOCUMENTARY("Documentary");

    private final String displayName;

    MovieGenderEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
