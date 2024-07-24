package org.game.ui;

import org.game.model.DifficultyLevel;

public interface HangmanPrinter<T> {
    T[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel);
    void printPicture(DifficultyLevel difficultyLevel, int pictureNumber);
}
