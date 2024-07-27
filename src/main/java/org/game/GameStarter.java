package org.game;

import org.game.view.DifficultyLevel;
import org.game.view.ConsoleHangmanPrinter;
import org.game.view.HangmanPrinter;
import org.game.view.io.*;
import org.game.view.io.InputReader;
import org.game.view.ui.*;

import java.util.List;

public class GameStarter {
    public static final String ASK_LEVEL_MESSAGE = """
                Игра Hangman начинается..
                Выберете уровень сложности:
                """;
    public static final String REPEAT_ROUND_MESSAGE = "Повторить раунд?";
    public static final String NEXT_LETTER = "Введите букву: ";
    public static final String YES_KEY = "Да";
    public static final String NO_KEY = "Нет";
    public static final String ROUND_NUMBER = "Раунд ";
    public static final String VICTORY_GAME_MESSAGE = "Вы победили!";
    public static final String LOSE_ROUND_MESSAGE = "Раунд окончен — допущено слишком много ошибок.";
    public static final String GAME_OVER_MESSAGE = "Игра окончена!";
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        IntegerInputValidator integerInputValidator = new IntegerInputValidator();
        Dialog<Integer> levelDialog = new IntegerDialog(
                reader,
                writer,
                ASK_LEVEL_MESSAGE,
                integerInputValidator,
                List.of(DifficultyLevel.EASY.getName(), DifficultyLevel.MEDIUM.getName(), DifficultyLevel.HARD.getName())
        );

        BooleanInputValidator booleanInputValidator = new BooleanInputValidator();
        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                reader,
                writer,
                REPEAT_ROUND_MESSAGE,
                booleanInputValidator,
                YES_KEY,
                NO_KEY
        );

        CharacterInputValidator characterInputValidator = new CharacterInputValidator();
        Dialog<Character> characterDialog = new CharacterDialog(
                reader,
                writer,
                NEXT_LETTER,
                characterInputValidator
        );

        DictionaryManager dictionaryManager = new DictionaryManager();
        MessageSender messageSender = new ConsoleMessageSender(writer);
        HangmanPrinter<String> hangmanPrinter = new ConsoleHangmanPrinter(writer);

        int difficultyLevelNumber = levelDialog.getInput();
        int roundNumber = 1;

        while (true) {
            DifficultyLevel difficultyLevel = getDifficultyLevel(difficultyLevelNumber);
            String textForWord = dictionaryManager.getRandomWordForDifficultyLevel(difficultyLevel);
            Round round = new Round(writer, characterDialog, difficultyLevel, textForWord, hangmanPrinter, messageSender);

            messageSender.sendMessage(ROUND_NUMBER, roundNumber);
            round.start();

            if (isRoundWon(round)) {
                if (isCurrentDifficultyLevelWasLast(round)) {
                    messageSender.sendMessage(VICTORY_GAME_MESSAGE);
                    break;
                }
                roundNumber++;
                difficultyLevelNumber++;
            } else {
                messageSender.sendMessage(LOSE_ROUND_MESSAGE);
                if (!wantRepeatRound(repeatRoundDialog)) {
                    messageSender.sendMessage(GAME_OVER_MESSAGE);
                    break;
                }
            }
        }
    }

    private static boolean isRoundWon(Round round) {
        return round.isWinner();
    }

    private static boolean wantRepeatRound(Dialog<Boolean> repeatRoundDialog) {
        return repeatRoundDialog.getInput();
    }

    private static DifficultyLevel getDifficultyLevel(int difficultyLevelValue) {
        return DifficultyLevel.values()[difficultyLevelValue - 1];
    }

    private static boolean isCurrentDifficultyLevelWasLast(Round round) {
        return round.getDifficultyLevel().equals(DifficultyLevel.HARD);
    }
}