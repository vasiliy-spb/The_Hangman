package org.game.view.io;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    private final Scanner scanner;
    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readOneLine() {
        return scanner.nextLine();
    }
}
