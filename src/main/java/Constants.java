public class Constants {
    public static final String HELLO_MESSAGE = """
            Игра Hangman начинается..
            Выберете уровень сложности:
                1 — лёгкий
                2 — средний
                3 — сложный
            """;
    public static final String CURRENT_WORD = "Слово: ";
    public static final String MISTAKES = "Ошибки: ";
    public static final String LETTER = "Буква: ";
    public static final String ROUND_NUMBER = "Раунд ";
    public static final String WRONG_ROUND_NUMBER = """
            Выберите корректный уровень сложности:
                1 — лёгкий
                2 — средний
                3 — сложный
            """;
    public static final String VICTORY_ROUND_MESSAGE = "Раунд пройден!";
    public static final String VICTORY_MESSAGE = "Вы победили!";
    public static final String GAME_OVER_MESSAGE = "Игра окончена!";
    public static final String LOSE_MESSAGE = """
            Игра окончена...
            1 — повторить раунд
            2 — начать игру с начала
            """;
    public static final String SMALL_WORD_TEMPLATE = "______";
    public static final String MIDDLE_WORD_TEMPLATE = "_______";
    public static final String LARGE_WORD_TEMPLATE = "________";
    public static final String NEXT_LETTER = "Введите букву: ";
    public static final String ONLY_RUSSIAN_LETTER_MISTAKE = "Принимаются только русские буквы";
    public static final String TOO_MUCH_LETTERS_MISTAKE = "Принимаются только одна буква";
    public static final String[] SMALL_HANGMAN_PICTURE = {
            "_____\n     |\n     o\n",
            "    /",
            "|",
            "\\\n",
            "    / ",
            "\\\n"
    };
    public static final String[] MIDDLE_HANGMAN_PICTURE = {
            "_____\n     |\n",
            "     o\n",
            "    /",
            "|",
            "\\\n",
            "    / ",
            "\\\n"
    };
    public static final String[] LARGE_HANGMAN_PICTURE = {
            "_____\n",
            "     |\n",
            "     o\n",
            "    /",
            "|",
            "\\\n",
            "    / ",
            "\\\n"
    };

    public static final String REPEAT_ROUND = """
            Повторить раунд?
            1 — да
            2 — нет
            """;
    public static final String INCORRECT_INPUT = "Выберите один из вариантов: ";

}
    /*

_____
     |
     o
    /|\
    / \


     */
