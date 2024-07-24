package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.Messages;
import org.game.dialogs.*;

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
                List.of(Messages.EASY_LEVEL_KEY, Messages.MEDIUM_LEVEL_KEY, Messages.HARD_LEVEL_KEY)
        );

        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                reader,
                writer,
                Messages.REPEAT_ROUND_MESSAGE,
                Messages.INCORRECT_INPUT_MISTAKE,
                Messages.YES_KEY,
                Messages.NO_KEY
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
        return switch (difficultyLevelValue) {
            case 2 -> DifficultyLevel.MEDIUM;
            case 3 -> DifficultyLevel.HARD;
            default -> DifficultyLevel.EASY;
        };
    }

    private static boolean isCurrentDifficultyLevelWasLast(Round round) {
        return round.getWordLength().equals(DifficultyLevel.HARD);
    }
}

/*

В начале игры:
— приветствуем
— спрашиваем уровень сложности
— играем раунды

В каждом раунде:
— выводим номер раунда
— обновляем дисплей
— делаем ходы

В каждый ход:
— спрашиваем букву
— проверяем букву
— проверяем закончилась ли игра

В конце раунда:
— если раунд пройден
    — если раунд не последний
        — переходим на след раунд
        — или заканчиваем игру (выигрыш)
— если раунд не пройден
    — спрашиваем, повторить ли раунд
        — если да — повторяем раунд
        — если нет, то завершаем игру (проигрыш)

 */