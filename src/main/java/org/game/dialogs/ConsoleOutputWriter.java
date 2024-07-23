package org.game.dialogs;

import java.io.PrintStream;

public class ConsoleOutputWriter implements OutputWriter{
    PrintStream writer;
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

    @Override
    public void writeInt(Integer num) {

    }
}
