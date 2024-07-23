package org.game.dialogs;

import java.util.List;

public class MainStringIgnoreCaseDialog {
    public static void main(String[] args) {
        final String yesKey = "Да";
        final String noKey = "Нет";
        final String maybeKey = "Возможно";

        Dialog<String> dialog = new StringIgnoreCaseDialog("Выберите один из вариантов ответа ", "Неправильный ввод", yesKey, noKey);

        String answer = dialog.input();

        System.out.println("Выбран вариант: " + answer);

        Dialog<String> listDialog = new StringIgnoreCaseDialog("Выберите один из вариантов ответа ", "Неправильный ввод", List.of(yesKey, noKey, maybeKey));

        answer = listDialog.input();

        System.out.println("Выбран вариант: " + answer);

    }
}
