import java.util.List;

public class Round {

    private Word roundWord;
    private Word currentWord;
    private final WordLength wordLength;
    private boolean winner;
    private boolean gameOver;
    private MessageManager messageManager;
    private char lastLetter;

    public Round(WordLength wordLength) {
        this.wordLength = wordLength;
        this.lastLetter = '\0';
    }

    void start() {
        this.messageManager = new MessageManager();
        DictionaryManager dictionaryManager = new DictionaryManager();
        String wordString = dictionaryManager.getRandomWord(wordLength);

//        System.out.println("слово: " + wordString);

        roundWord = new Word(wordString);
        switch (wordLength) {
            case SMALL -> currentWord = new Word(Constants.SMALL_WORD_TEMPLATE);
            case MIDDLE -> currentWord = new Word(Constants.MIDDLE_WORD_TEMPLATE);
            case LARGE -> currentWord = new Word(Constants.LARGE_WORD_TEMPLATE);
        }
        winner = false;
        gameOver = false;
        messageManager.refreshDisplay(currentWord, lastLetter);
        while (!gameOver) {
            makeMove();
        }
    }

    void makeMove() {
        lastLetter = Character.toUpperCase(messageManager.askNextLetter());
        boolean isCorrectLetter = checkLetter(lastLetter);
        if (isCorrectLetter) {
            List<Integer> positions = roundWord.getLetterPositions(lastLetter);
            currentWord.putLetter(lastLetter, positions);
            if (isGameOver()) gameOver();
        } else {
            currentWord.addMistake(lastLetter);
            if (currentWord.mistakeList.size() >= roundWord.length) gameOver = true;
        }
        messageManager.refreshDisplay(currentWord, lastLetter);
        printHangman();
    }

    private void printHangman() {
        switch (wordLength) {
            case SMALL -> messageManager.printHangmanPicture(Constants.SMALL_HANGMAN_PICTURE, currentWord.mistakeList.size());
            case MIDDLE -> messageManager.printHangmanPicture(Constants.MIDDLE_HANGMAN_PICTURE, currentWord.mistakeList.size());
            case LARGE -> messageManager.printHangmanPicture(Constants.LARGE_HANGMAN_PICTURE, currentWord.mistakeList.size());
        }
    }

    private boolean checkLetter(char letter) {
        for (char l : roundWord.getLettersAsChars())
            if (l == letter) return true;
        return false;
    }

    private boolean isGameOver() {
        if (currentWord.getMistakeCount() >= roundWord.length) return true;
        if (isWordCorrect(currentWord)) winner = true;
        return winner;
    }

    void gameOver() {
        gameOver = true;
        if (winner) messageManager.showRoundVictoryMessage();
        else messageManager.showLoseMessage();
    }

    private boolean isWordCorrect(Word currentWord) {
        return roundWord.equals(currentWord);
    }

    public WordLength getWordLength() {
        return wordLength;
    }

    public boolean isWinner() {
        return winner;
    }
}
