package org.game.dialogs;

import java.util.List;

public class MainIntegerDialog {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        final String yesKey = "Да";
        final String noKey = "Нет";
        final String maybeKey = "Возможно";

        Dialog<Integer> dialog = new IntegerDialog(reader, writer, "Выберите один из вариантов ответа ", "Неправильный ввод", yesKey, noKey);

        int answer = dialog.input();

        writer.writeLine("Выбран вариант: " + answer);

        Dialog<Integer> listDialog = new IntegerDialog(reader, writer, "Выберите один из вариантов ответа ", "Неправильный ввод", List.of(yesKey, noKey, maybeKey));

        answer = listDialog.input();

        writer.writeLine("Выбран вариант: " + answer);

    }
}
