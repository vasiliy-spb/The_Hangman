package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.HangmanPictures;

public class ConsoleHangmanPrinter extends HangmanPrinter {
    @Override
    public String[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> HangmanPictures.SMALL_HANGMAN_PICTURE;
            case MEDIUM -> HangmanPictures.MIDDLE_HANGMAN_PICTURE;
            case HARD -> HangmanPictures.LARGE_HANGMAN_PICTURE;
        };
    }

    @Override
    public void printPicture(DifficultyLevel difficultyLevel, int mistakeCount) {
        String currentPicture = getPictureForDifficultyLevel(difficultyLevel)[mistakeCount];
        System.out.println(currentPicture);
    }
}
