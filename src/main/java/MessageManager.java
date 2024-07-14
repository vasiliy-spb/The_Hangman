import java.util.Scanner;

public class MessageManager {

    void showStartMessage() {
        System.out.println(Constants.HELLO_MESSAGE);
    }

    void showGameVictoryMessage() {
        System.out.println(Constants.VICTORY_MESSAGE);
    }

    void showRoundVictoryMessage() {
        System.out.println(Constants.VICTORY_ROUND_MESSAGE);
    }

    void showLoseMessage() {
        System.out.println(Constants.LOSE_MESSAGE);
    }

    void refreshDisplay(Word word, char lastLetter) {
        System.out.println(Constants.CURRENT_WORD + word.toString());
        System.out.println(Constants.MISTAKES + "(" + word.getMistakeCount() + ") " + word.getMistakes());
        System.out.println(Constants.LETTER + lastLetter);
        System.out.println();
    }

    public char askNextLetter() {
        boolean validLetter = false;
        Scanner scanner = new Scanner(System.in);
        char letter = '\0';
        while (!validLetter) {
            System.out.println(Constants.NEXT_LETTER);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 0) {
                showWrongLetterMessage(Constants.NOT_ENOUGH_LETTERS_MISTAKE);
                continue;
            } else if (input.length() != 1) {
                showWrongLetterMessage(Constants.TOO_MUCH_LETTERS_MISTAKE);
                continue;
            }
            letter = input.charAt(0);
            if (letter != 1025 && (letter < 1040 || letter > 1071))
                if (Character.isLetter(letter)) showWrongLetterMessage(Constants.ONLY_RUSSIAN_LETTER_MISTAKE);
                else showWrongLetterMessage(Constants.INVALID_CHARACTER_MISTAKE);
            else validLetter = true;
        }
        return letter;
    }

    private void showWrongLetterMessage(String mistakeMessage) {
        System.out.println(mistakeMessage);
    }

    public void showGameOverMessage() {
        System.out.println(Constants.GAME_OVER_MESSAGE);
    }

    public void showRoundNumber(int number) {
        System.out.println(Constants.ROUND_NUMBER + number);
    }

    public void printHangmanPicture(String[] smallHangmanPicture, int mistakeCount) {
        for (int i = 0; i < mistakeCount; i++) {
            System.out.print(smallHangmanPicture[i]);
        }
        System.out.println();
    }

    public int askLevel() {
        Scanner scanner = new Scanner(System.in);
        int level = 0;
        while (level < 1 || level > 3) {
            try {
                level = scanner.nextInt();
            } catch (Exception e) {
                showWrongRoundNumberMessage();
            }
            if (level < 1 || level > 3) showWrongRoundNumberMessage();
        }
        return level;
    }

    private void showWrongRoundNumberMessage() {
        System.out.println(Constants.WRONG_ROUND_NUMBER);
    }

    public boolean askRepeatRound() {
        System.out.println(Constants.REPEAT_ROUND);
        Scanner scanner = new Scanner(System.in);
        int repeat = -1;
        while (repeat != 1 && repeat != 2) {
            try {
                repeat = scanner.nextInt();
                if (repeat != 1 && repeat != 2) {
                    System.out.println(Constants.INCORRECT_INPUT);
                    System.out.println(Constants.REPEAT_ROUND);
                }
            } catch (Exception e) {
                System.out.println(Constants.INCORRECT_INPUT);
                scanner.next();
                System.out.println(Constants.REPEAT_ROUND);
            }
        }
        return repeat == 1;
    }
}
