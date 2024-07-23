package org.game.constants;

public final class Messages {
    public static final String ASK_LEVEL_MESSAGE = """
                Игра Hangman начинается..
                Выберете уровень сложности:
                """;
    public static final String WRONG_LEVEL_MESSAGE = "Введён некорректный уровень сложности";
    public static final String EASY_LEVEL_KEY = "лёгкий";
    public static final String MEDIUM_LEVEL_KEY = "средний";
    public static final String HARD_LEVEL_KEY = "сложный";
    public static final String YES_KEY = "Да";
    public static final String NO_KEY = "Нет";
    public static final String CURRENT_WORD = "Слово: ";
    public static final String MISTAKES = "Ошибки: ";
    public static final String LETTER = "Буква: ";
    public static final String ROUND_NUMBER = "Раунд ";
    public static final String WRONG_ROUND_NUMBER_MISTAKE = """
            Выберите корректный уровень сложности:
            """;
    public static final String VICTORY_ROUND_MESSAGE = "Раунд пройден!";
    public static final String VICTORY_GAME_MESSAGE = "Вы победили!";
    public static final String GAME_OVER_MESSAGE = "Игра окончена!";
    public static final String LOSE_ROUND_MESSAGE = """
            Раунд окончен — допущено слишком много ошибок.
            """;
    public static final String INCORRECT_INPUT_MISTAKE = "Выберите один из вариантов";
    public static final String NEXT_LETTER = "Введите букву: ";
    public static final String GENERAL_LETTER_MISTAKE = "Введён неподдерживаемый символ.";
    public static final String REPEAT_ROUND_MESSAGE = """
            Повторить раунд?
            """;

    private Messages() {

    }
}
