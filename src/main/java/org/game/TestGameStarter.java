package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.Messages;
import org.game.dialogs.BooleanDialog;
import org.game.dialogs.Dialog;
import org.game.dialogs.IntegerDialog;

import java.util.List;

public class TestGameStarter {
    public static void main(String[] args) {

        Dialog<Integer> levelDialog = new IntegerDialog(
                Messages.ASK_LEVEL_MESSAGE,
                Messages.WRONG_LEVEL_MESSAGE,
                List.of(Messages.EASY_LEVEL_KEY, Messages.MEDIUM_LEVEL_KEY, Messages.HARD_LEVEL_KEY)
        );

        int level = levelDialog.input();

        MessageSender messageSender = new ConsoleMessageSender();


        int roundNumber = 1;
        Round round;
        while (true) {
            DifficultyLevel difficultyLevel = getDifficultyLevel(level);
            round = new Round(difficultyLevel);

            messageSender.sendMessage(Messages.ROUND_NUMBER, roundNumber);
            round.testStart();

            if (round.isWinner()) {
                roundNumber++;
                if (isCurrentDifficultyLevelWasLast(round)) {
                    break;
                }
                level++;
            } else {
                messageSender.sendMessage(Messages.LOSE_ROUND_MESSAGE);
                if (!wantRepeatRound()) {
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

    private static boolean wantRepeatRound() {
        Dialog<Boolean> repeatRoundDialog = new BooleanDialog(
                Messages.REPEAT_ROUND_MESSAGE,
                Messages.INCORRECT_INPUT_MISTAKE,
                Messages.YES_KEY,
                Messages.NO_KEY
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
