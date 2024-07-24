package org.game.model;

public enum DifficultyLevel {
    EASY (6, "лёгкий"),
    MEDIUM (7, "средний"),
    HARD (8, "сложный");
    private final int value;
    private final String name;
    DifficultyLevel(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
