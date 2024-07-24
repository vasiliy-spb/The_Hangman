package org.game.dialogs;

import java.util.List;

public class MainStringIgnoreCaseDialog {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        final String yesKey = "Да";
        final String noKey = "Нет";
        final String maybeKey = "Возможно";

        Dialog<String> dialog = new StringIgnoreCaseDialog(reader, writer, "Выберите один из вариантов ответа ", "Неправильный ввод", yesKey, noKey);

        String answer = dialog.input();

        writer.writeLine("Выбран вариант: " + answer);

        Dialog<String> listDialog = new StringIgnoreCaseDialog(reader, writer, "Выберите один из вариантов ответа ", "Неправильный ввод", List.of(yesKey, noKey, maybeKey));

        answer = listDialog.input();

        writer.writeLine("Выбран вариант: " + answer);

    }
}
