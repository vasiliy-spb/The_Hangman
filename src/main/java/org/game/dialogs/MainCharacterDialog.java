package org.game.dialogs;

public class MainCharacterDialog {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Dialog<Character> dialog = new CharacterDialog(reader, writer, "Введите букву: ", "Неправильный ввод");

        int answer = dialog.input();

        writer.writeLine("Вы ввели: " + (char) answer);

    }
}
