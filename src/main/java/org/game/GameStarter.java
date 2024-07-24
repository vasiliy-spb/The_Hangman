package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.Messages;
import org.game.dialogs.*;

import java.util.List;

public class GameStarter {
    public static void main(String[] args) {

        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();

        String askLevelMessage = """
                Игра Hangman начинается..
                Выберете уровень сложности:
                """;
        String wrongLevelMessage = "Введён некорректный уровень сложности";
        String easyLevel = "лёгкий";
        String mediumLevel = "средний";
        String hardLevel = "сложный";

        Dialog<Integer> levelDialog = new IntegerDialog(
                reader,
                writer,
                askLevelMessage,
                wrongLevelMessage,
                List.of(easyLevel, mediumLevel, hardLevel)
        );

        int level = levelDialog.input();

        MessageSender messageSender = new ConsoleMessageSender();


        int roundNumber = 1;
        Round round;
        while (true) {
            DifficultyLevel difficultyLevel = getDifficultyLevel(level);
            round = new Round(reader, writer, difficultyLevel);

            messageSender.sendMessage(Messages.ROUND_NUMBER, roundNumber);
            round.start();

            if (round.isWinner()) {
                roundNumber++;
                if (isCurrentDifficultyLevelWasLast(round)) {
                    break;
                }
                level++;
            } else {
                if (!wantRepeatRound(reader, writer)) {
                    break;
                }
            }
        }

        if (round.isWinner()) {
            messageSender.sendMessage(Messages.VICTORY_GAME_MESSAGE);
        } else {
            messageSender.sendMessage(Messages.GAME_OVER_MESSAGE);
        }

    }

    private static boolean wantRepeatRound(InputReader reader,
                                           OutputWriter writer) {
        String yesKey = "Да";
        String noKey = "Нет";
        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                reader,
                writer,
                Messages.REPEAT_ROUND_MESSAGE,
                Messages.WRONG_ROUND_NUMBER_MISTAKE,
                yesKey,
                noKey
        );
        return repeatRoundDialog.input();
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