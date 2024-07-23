package org.game;

import org.game.constants.DifficultyLevel;

public abstract class HangmanPrinter {
    public abstract String[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel);
    public abstract void printPicture(DifficultyLevel difficultyLevel, int mistakeCount);
}
