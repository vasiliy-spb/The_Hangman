package org.game;

import org.game.constants.DifficultyLevel;
import org.game.constants.Messages;
import org.game.dialogs.CharacterDialog;
import org.game.dialogs.Dialog;

public class Round {

    private Word roundWord;
    private final DifficultyLevel difficultyLevel;
    private boolean winner;
    private boolean gameOver;
    private char lastLetterValue;
    private HangmanPrinter hangmanPrinter;

    public Round(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        this.lastLetterValue = '\0';
        this.hangmanPrinter = new ConsoleHangmanPrinter();
    }

    void start() {
        DictionaryManager dictionaryManager = new DictionaryManager();
        String text = dictionaryManager.getRandomWordForDifficultyLevel(difficultyLevel);
        roundWord = new Word(text);
        winner = false;
        gameOver = false;
        refreshDisplay();
        while (!gameOver) {
            makeMove();
        }
    }

    void testStart() {
        DictionaryManager dictionaryManager = new DictionaryManager();
        String text = dictionaryManager.getRandomWordForDifficultyLevel(difficultyLevel);

        System.out.println("слово: " + text);

        roundWord = new Word(text);

        winner = false;
        gameOver = false;
        refreshDisplay();
        while (!gameOver) {
            System.out.println("roundWord = " + roundWord);
            makeMove();
        }
    }

    void refreshDisplay() {
        System.out.println(Messages.CURRENT_WORD + roundWord.getStringRepresentation());
        System.out.println(Messages.MISTAKES + "(" + roundWord.getMistakeCount() + ") " + roundWord.getMistakesHistory());
        System.out.println(Messages.LETTER + lastLetterValue);
    }


    void makeMove() {
        Dialog<Character> dialog = new CharacterDialog(Messages.NEXT_LETTER, Messages.GENERAL_LETTER_MISTAKE);
        lastLetterValue = Character.toUpperCase(dialog.input());
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
        MessageSender messageSender = new ConsoleMessageSender();
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
