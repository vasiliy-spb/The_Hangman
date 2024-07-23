package org.game.dialogs;

public abstract class Dialog<T> {
    final String text;
    final String errorMessage;
    Dialog(String text, String errorMessage) {
        this.text = text;
        this.errorMessage = errorMessage;
    }

    public String getText() {
        return text;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public abstract T input();
}
