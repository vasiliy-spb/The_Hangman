package org.game.model;

import java.util.*;

public class Word {
    private Letter[] letters;
    final private List<Character> mistakeList;
    final private Set<Character> mistakeSet;

    public Word(String text) {
        createLetters(text);
        mistakeList = new ArrayList<>();
        mistakeSet = new HashSet<>();
    }

    public String getStringRepresentation() {
        StringBuilder stringRepresentation = new StringBuilder();
        for (Letter letter : letters) {
            if (letter.isVisible()) {
                stringRepresentation.append(letter.getLetterValue());
            } else {
                stringRepresentation.append("_");
            }
            stringRepresentation.append(" ");
        }
        return stringRepresentation.toString().trim();
    }

    public String getMistakesHistory() {
        StringBuilder mistakeHistoryString = new StringBuilder();
        for (char letterValue : mistakeList) {
            mistakeHistoryString.append(letterValue).append(" ");
        }
        return mistakeHistoryString.toString().trim();
    }

    public int getMistakeCount() {
        return mistakeSet.size();
    }

    private void createLetters(String text) {
        text = text.toUpperCase();
        letters = new Letter[text.length()];
        for (int i = 0; i < text.length(); i++) {
            letters[i] = new Letter(text.charAt(i), false);
        }
    }

    public void addMistake(char letterValue) {
        if (mistakeSet.contains(letterValue)) return;
        mistakeList.add(letterValue);
        mistakeSet.add(letterValue);
    }

    public boolean containsLetterWithValue(char otherLetterValue) {
        return Arrays.stream(letters)
                .anyMatch(letter -> letter.getLetterValue() == otherLetterValue);
    }

    public void openLetter(char needToOpenLetterValue) {
        Arrays.stream(letters)
                .filter(letter -> letter.getLetterValue() == needToOpenLetterValue)
                .forEach(Letter::open);
    }

    public boolean isWordSolved() {
        return Arrays.stream(letters)
                .allMatch(Letter::isVisible);
    }

    private static class Letter {
        private final char letterValue;
        private boolean visible;

        private Letter(char letterValue, boolean visible) {
            this.letterValue = letterValue;
            this.visible = visible;
        }

        private void open() {
            visible = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Letter letter = (Letter) o;
            return letterValue == letter.letterValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(letterValue);
        }

        public char getLetterValue() {
            return letterValue;
        }

        public boolean isVisible() {
            return visible;
        }

        @Override
        public String toString() {
            return "Letter[" +
                    "letterValue=" + letterValue + ", " +
                    "visible=" + visible + ']';
        }

    }

    public int getLettersCount() {
        return letters.length;
    }

    @Override
    public String toString() {
        return "Word{" +
                "letters=" + Arrays.toString(letters) +
                ", mistakeList=" + mistakeList +
                ", mistakeSet=" + mistakeSet +
                '}';
    }
}
