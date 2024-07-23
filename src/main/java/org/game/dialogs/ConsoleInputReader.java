package org.game.dialogs;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    Scanner scanner;
    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String readOneLine() {
        return scanner.nextLine();
    }
}
