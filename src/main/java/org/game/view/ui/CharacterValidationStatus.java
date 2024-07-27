package org.game.view.ui;

public enum CharacterValidationStatus implements ValidationStatus {
    CORRECT_CHARACTER (""),
    TOO_MUCH_CHARACTERS ("Принимаются только одна буква"),
    CHARACTER_NOT_LETTER ("Принимаются только буквы"),
    WRONG_LOCALE_CHARACTER ("Принимаются только русские буквы"),
    EMPTY_CHARACTER ("Нужно ввести какую-либо букву");
    private final String statusMessage;
    CharacterValidationStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
