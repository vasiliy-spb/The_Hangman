package org.game.dialogs;

import java.io.PrintStream;

public class ConsoleOutputWriter implements OutputWriter{
    private final PrintStream writer;
    public ConsoleOutputWriter() {
        this.writer = System.out;
    }

    @Override
    public void writeString(String str) {
        writer.print(str);
    }

    @Override
    public void writeLine(String line) {
        writer.println(line);
    }
}
