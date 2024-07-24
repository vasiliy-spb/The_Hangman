package org.game.model;

public final class Messages {
    public static final String ASK_LEVEL_MESSAGE = """
                Игра Hangman начинается..
                Выберете уровень сложности:
                """;
    public static final String INCORRECT_INPUT_MISTAKE = "Выберите один из вариантов";
    public static final String WRONG_LEVEL_MESSAGE = "Введён некорректный уровень сложности";
    public static final String ROUND_NUMBER = "Раунд ";
    public static final String NEXT_LETTER = "Введите букву: ";
    public static final String GENERAL_LETTER_MISTAKE = "Введён неподдерживаемый символ.";
    public static final String LOSE_ROUND_MESSAGE = "Раунд окончен — допущено слишком много ошибок.";
    public static final String REPEAT_ROUND_MESSAGE = "Повторить раунд?";
    public static final String VICTORY_ROUND_MESSAGE = "Раунд пройден!";
    public static final String VICTORY_GAME_MESSAGE = "Вы победили!";
    public static final String GAME_OVER_MESSAGE = "Игра окончена!";

    private Messages() {

    }
}
