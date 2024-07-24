package org.game.ui;

import org.game.model.DifficultyLevel;
import org.game.model.HangmanPictures;
import org.game.io.OutputWriter;
import org.game.ui.HangmanPrinter;

public class ConsoleHangmanPrinter implements HangmanPrinter<String> {
    private final OutputWriter writer;
    public ConsoleHangmanPrinter(OutputWriter writer) {
        this.writer = writer;
    }

    @Override
    public String[] getPictureForDifficultyLevel(DifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> HangmanPictures.SMALL_HANGMAN_PICTURE;
            case MEDIUM -> HangmanPictures.MIDDLE_HANGMAN_PICTURE;
            case HARD -> HangmanPictures.LARGE_HANGMAN_PICTURE;
        };
    }

    @Override
    public void printPicture(DifficultyLevel difficultyLevel, int pictureNumber) {
        String currentPicture = getPictureForDifficultyLevel(difficultyLevel)[pictureNumber];
        writer.writeLine(currentPicture);
    }
}
