package org.game;

import org.game.model.DifficultyLevel;
import org.game.model.Messages;
import org.game.io.*;
import org.game.ui.*;

import java.util.List;

public class TestGameStarter {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        IntegerInputValidator integerInputValidator = new IntegerInputValidator();
        Dialog<Integer> levelDialog = new IntegerDialog(
                reader,
                writer,
                Messages.ASK_LEVEL_MESSAGE,
                integerInputValidator,
                List.of(DifficultyLevel.EASY.getName(), DifficultyLevel.MEDIUM.getName(), DifficultyLevel.HARD.getName())
        );

        BooleanInputValidator booleanInputValidator = new BooleanInputValidator();
        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                reader,
                writer,
                Messages.REPEAT_ROUND_MESSAGE,
                booleanInputValidator,
                Messages.YES_KEY,
                Messages.NO_KEY
        );

        CharacterInputValidator characterInputValidator = new CharacterInputValidator();
        Dialog<Character> characterDialog = new CharacterDialog(
                reader,
                writer,
                Messages.NEXT_LETTER,
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

            System.out.println("Слово раунда: " + textForWord);

            messageSender.sendMessage(Messages.ROUND_NUMBER, roundNumber);
            round.testStart();

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
