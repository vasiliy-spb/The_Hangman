package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.Messages;
import org.game.dialogs.Dialog;
import org.game.dialogs.OutputWriter;

public class Round {

    private final OutputWriter writer;
    private final Word roundWord;
    private boolean winner;
    private boolean gameOver;
    private char lastLetterValue;
    private final HangmanPrinter hangmanPrinter;
    private final DifficultyLevel difficultyLevel;
    private final MessageSender messageSender;
    private final Dialog<Character> characterDialog;

    public Round(
            OutputWriter writer,
            Dialog<Character> characterDialog,
            DifficultyLevel difficultyLevel,
            String textForWord,
            HangmanPrinter hangmanPrinter,
            MessageSender messageSender) {
        this.writer = writer;
        this.characterDialog = characterDialog;
        this.difficultyLevel = difficultyLevel;
        this.roundWord = new Word(textForWord);
        this.hangmanPrinter = hangmanPrinter;
        this.messageSender = messageSender;
        this.lastLetterValue = '\0';
    }

    void start() {
        winner = false;
        gameOver = false;
        refreshDisplay();
        while (!gameOver) {
            makeMove();
        }
    }

    void testStart() {
        winner = false;
        gameOver = false;
        refreshDisplay();
        while (!gameOver) {
            writer.writeLine("roundWord = " + roundWord);
            makeMove();
        }
    }

    void refreshDisplay() {
        writer.writeLine(Messages.CURRENT_WORD + roundWord.getStringRepresentation());
        writer.writeLine(Messages.MISTAKES + "(" + roundWord.getMistakeCount() + ") " + roundWord.getMistakesHistory());
        writer.writeLine(Messages.LETTER + lastLetterValue);
    }


    void makeMove() {
        lastLetterValue = Character.toUpperCase(characterDialog.getInput());
        if (isCorrectLetter(lastLetterValue)) {
            roundWord.openLetter(lastLetterValue);
        } else {
            roundWord.addMistake(lastLetterValue);
        }
        if (isGameOver()) {
            gameOver();
        }
        refreshDisplay();
        hangmanPrinter.printPicture(difficultyLevel, roundWord.getMistakeCount());
    }


    private boolean isCorrectLetter(char letterValue) {
        return roundWord.containsLetterWithValue(letterValue);
    }

    private boolean isGameOver() {
        if (roundWord.getMistakeCount() >= roundWord.getLettersCount()) {
            return true;
        }
        if (roundWord.isWordSolved()) {
            winner = true;
        }
        return winner;
    }

    void gameOver() {
        gameOver = true;
        if (winner) {
            messageSender.sendMessage(Messages.VICTORY_ROUND_MESSAGE);
        } else {
            messageSender.sendMessage(Messages.LOSE_ROUND_MESSAGE);
        }
    }


    public DifficultyLevel getWordLength() {
        return difficultyLevel;
    }

    public boolean isWinner() {
        return winner;
    }
}
