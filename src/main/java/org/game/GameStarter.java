package org.game;

import org.game.model.DifficultyLevel;
import org.game.model.Keys;
import org.game.model.Messages;
import org.game.io.*;
import org.game.ui.*;

import java.util.List;

public class GameStarter {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        Dialog<Integer> levelDialog = new IntegerDialog(
                reader,
                writer,
                Messages.ASK_LEVEL_MESSAGE,
                Messages.WRONG_LEVEL_MESSAGE,
                List.of(DifficultyLevel.EASY.getName(), DifficultyLevel.MEDIUM.getName(), DifficultyLevel.HARD.getName())
        );

        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                reader,
                writer,
                Messages.REPEAT_ROUND_MESSAGE,
                Messages.INCORRECT_INPUT_MISTAKE,
                Keys.YES_KEY,
                Keys.NO_KEY
        );

        Dialog<Character> characterDialog = new CharacterDialog(
                reader,
                writer,
                Messages.NEXT_LETTER,
                Messages.GENERAL_LETTER_MISTAKE
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

            messageSender.sendMessage(Messages.ROUND_NUMBER, roundNumber);
            round.start();

            if (isRoundWon(round)) {
                if (isCurrentDifficultyLevelWasLast(round)) {
                    messageSender.sendMessage(Messages.VICTORY_GAME_MESSAGE);
                    break;
                }
                roundNumber++;
                difficultyLevelNumber++;
            } else {
                messageSender.sendMessage(Messages.LOSE_ROUND_MESSAGE);
                if (!wantRepeatRound(repeatRoundDialog)) {
                    messageSender.sendMessage(Messages.GAME_OVER_MESSAGE);
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