package org.game.dialogs;

public class MainCharacterDialog {
    public static void main(String[] args) {
        Dialog<Character> dialog = new CharacterDialog("Введите букву: ", "Неправильный ввод");

        int answer = dialog.input();

        System.out.println("Вы ввели: " + (char) answer);

    }
}
