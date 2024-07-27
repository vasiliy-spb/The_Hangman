package org.game.view;

import org.game.view.io.OutputWriter;

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
