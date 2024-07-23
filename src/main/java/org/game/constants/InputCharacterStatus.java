package org.game.constants;

public enum InputCharacterStatus {
    CORRECT_CHARACTER (""),
    TOO_MUCH_CHARACTERS ("Принимаются только одна буква"),
    CHARACTER_NOT_LETTER ("Принимаются только буквы"),
    WRONG_LOCALE_CHARACTER ("Принимаются только русские буквы"),
    EMPTY_CHARACTER ("Нужно ввести какую-либо букву");
    private final String value;
    InputCharacterStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
