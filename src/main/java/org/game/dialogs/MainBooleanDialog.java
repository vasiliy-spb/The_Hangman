package org.game.dialogs;

public class MainBooleanDialog {
    public static void main(String[] args) {
        final String yesKey = "Да";
        final String noKey = "Нет";

        Dialog<Boolean> dialog = new BooleanDialog("Хотите повторить раунд?", "Неправильный ввод", yesKey, noKey);

        boolean answer = dialog.input();

        System.out.println("Вы ввели: " + answer);
    }
}
