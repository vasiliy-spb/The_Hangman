package org.game.ui;

import org.game.io.InputReader;
import org.game.io.OutputWriter;

public abstract class Dialog<T> {
    final InputReader reader;
    final OutputWriter writer;
    final String text;
    Validator validator;
    Dialog(InputReader reader, OutputWriter writer, String text, Validator validator) {
        this.reader = reader;
        this.writer = writer;
        this.text = text;
        this.validator = validator;
    }

    public String getText() {
        return text;
    }

    public abstract T getInput();
}
