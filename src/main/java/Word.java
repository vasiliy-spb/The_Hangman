import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Word {
    Letter[] letters;
    List<Letter> mistakeList;
    int length;

    public Word(String word) {
        this.length = word.length();
        createLetters(word);
        mistakeList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Arrays.equals(letters, word.letters);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(letters);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Letter letter : letters)
            str.append(letter.letter).append(" ");
        return str.toString().trim();
    }

    public String getMistakes() {
        StringBuilder str = new StringBuilder();
        for (Letter letter : mistakeList)
            str.append(letter.letter).append(" ");
        return str.toString().trim();
    }

    public int getMistakeCount() {
        return mistakeList.size();
    }

    public void createLetters(String word) {
        word = word.toUpperCase();
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i), i);
        }
    }

    public List<Integer> getLetterPositions(char letter) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].letter == letter) positions.add(i);
        }
        return positions;
    }

    public void putLetter(char letter, List<Integer> positions) {
        for (int i : positions)
            letters[i] = new Letter(letter, i);
    }

    public void addMistake(char letter) {
        for (Letter l : mistakeList)
            if (l.letter == letter) return;
        mistakeList.add(new Letter(letter, -1));
    }

    public char[] getLettersAsChars() {
        char[] chars = new char[letters.length];
        for (int i = 0; i < letters.length; i++) {
            chars[i] = Character.toUpperCase(letters[i].letter);
        }
        return chars;
    }

    private static class Letter {
        char letter;
        int index;

        public Letter(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Letter letter1 = (Letter) o;
            return letter == letter1.letter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(letter);
        }

        @Override
        public String toString() {
            return letter + "";
        }
    }
}
