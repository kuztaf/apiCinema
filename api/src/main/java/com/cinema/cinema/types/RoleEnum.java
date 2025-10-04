package com.cinema.cinema.types;

public enum RoleEnum {
    USER("user"),
    ADMIN("admin"),
    GUEST("guest");

    private final String displayName;

    RoleEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
