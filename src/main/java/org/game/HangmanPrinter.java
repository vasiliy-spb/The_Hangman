package org.game;

import org.game.constants.DifficultyLevel;

public interface HangmanPrinter<T> {
    T[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel);
    void printPicture(DifficultyLevel difficultyLevel, int pictureNumber);
}
