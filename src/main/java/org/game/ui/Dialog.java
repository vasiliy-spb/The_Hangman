package org.game.ui;

import org.game.io.InputReader;
import org.game.io.OutputWriter;

public abstract class Dialog<T> {
    final InputReader reader;
    final OutputWriter writer;
    final String text;
    final String errorMessage;
    Dialog(InputReader reader, OutputWriter writer, String text, String errorMessage) {
        this.reader = reader;
        this.writer = writer;
        this.text = text;
        this.errorMessage = errorMessage;
    }

    public String getText() {
        return text;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public abstract T getInput();
}
