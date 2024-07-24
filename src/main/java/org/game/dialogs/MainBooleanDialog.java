package org.game.dialogs;

public class MainBooleanDialog {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        final String yesKey = "Да";
        final String noKey = "Нет";

        Dialog<Boolean> dialog = new BooleanDialog(reader, writer, "Хотите повторить раунд?", "Неправильный ввод", yesKey, noKey);

        boolean answer = dialog.input();

        writer.writeLine("Вы ввели: " + answer);
    }
}
