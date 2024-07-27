package org.game;

import org.game.view.ui.Dialog;
import org.game.view.DifficultyLevel;
import org.game.model.MistakeHolder;
import org.game.model.Word;
import org.game.view.io.MessageSender;
import org.game.view.io.OutputWriter;
import org.game.view.HangmanPrinter;

public class Round {

    private final OutputWriter writer;
    private final Word roundWord;
    private boolean winner;
    private boolean gameOver;
    private char lastLetterValue;
    private final HangmanPrinter<String> hangmanPrinter;
    private final DifficultyLevel difficultyLevel;
    private final MessageSender messageSender;
    private final Dialog<Character> characterDialog;
    private final MistakeHolder mistakeHolder;
    public static final String CURRENT_WORD = "Слово: ";
    public static final String MISTAKES = "Ошибки: ";
    public static final String LETTER = "Буква: ";
    public static final String VICTORY_ROUND_MESSAGE = "Раунд пройден!";
    public static final String LOSE_ROUND_MESSAGE = "Раунд окончен — допущено слишком много ошибок.";

    public Round(
            OutputWriter writer,
            Dialog<Character> characterDialog,
            DifficultyLevel difficultyLevel,
            String textForWord,
            HangmanPrinter<String> hangmanPrinter,
            MessageSender messageSender) {
        this.writer = writer;
        this.characterDialog = characterDialog;
        this.difficultyLevel = difficultyLevel;
        this.mistakeHolder = new MistakeHolder();
        this.roundWord = new Word(textForWord, mistakeHolder);
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

    void refreshDisplay() {
        writer.writeLine(CURRENT_WORD + roundWord.getStringRepresentation());
        writer.writeLine(MISTAKES + "(" + mistakeHolder.getMistakeCount() + ") " + mistakeHolder.getMistakesHistory());
        writer.writeLine(LETTER + lastLetterValue);
    }

    void makeMove() {
        lastLetterValue = Character.toUpperCase(characterDialog.getInput());
        if (isCorrectLetter(lastLetterValue)) {
            roundWord.openLetter(lastLetterValue);
        } else {
            mistakeHolder.addMistake(lastLetterValue);
        }
        if (isGameOver()) {
            gameOver();
        }
        refreshDisplay();
        hangmanPrinter.printPicture(difficultyLevel, mistakeHolder.getMistakeCount());
    }

    private boolean isCorrectLetter(char letterValue) {
        return roundWord.containsLetterWithValue(letterValue);
    }

    private boolean isGameOver() {
        if (mistakeHolder.getMistakeCount() >= roundWord.getLettersCount()) {
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
            messageSender.sendMessage(VICTORY_ROUND_MESSAGE);
        } else {
            messageSender.sendMessage(LOSE_ROUND_MESSAGE);
        }
    }


    public DifficultyLevel getWordLength() {
        return difficultyLevel;
    }

    public boolean isWinner() {
        return winner;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
}
