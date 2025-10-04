package com.cinema.cinema.types;

public enum ReservedSeatStatusEnum {
    HELD("held"),
    CONFIRMED("confirmed"),
    RELEASED("released");

    private final String displayName;

    ReservedSeatStatusEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
