package org.game.dialogs;

import java.util.List;

public class MainIntegerDialog {
    public static void main(String[] args) {
        final String yesKey = "Да";
        final String noKey = "Нет";
        final String maybeKey = "Возможно";

        Dialog<Integer> dialog = new IntegerDialog("Выберите один из вариантов ответа ", "Неправильный ввод", yesKey, noKey);

        int answer = dialog.input();

        System.out.println("Выбран вариант: " + answer);

        Dialog<Integer> listDialog = new IntegerDialog("Выберите один из вариантов ответа ", "Неправильный ввод", List.of(yesKey, noKey, maybeKey));

        answer = listDialog.input();

        System.out.println("Выбран вариант: " + answer);

    }
}
