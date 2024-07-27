package org.game.view;

public interface HangmanPrinter<T> {
    T[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel);
    void printPicture(DifficultyLevel difficultyLevel, int pictureNumber);
}
