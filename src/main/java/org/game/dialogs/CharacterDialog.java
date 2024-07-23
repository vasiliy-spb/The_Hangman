package org.game.dialogs;

import org.game.CharacterInputValidator;
import org.game.constants.InputCharacterStatus;

import java.util.Scanner;

public class CharacterDialog extends Dialog<Character> {
    CharacterInputValidator inputValidator;
    public CharacterDialog(String text, String errorMessage) {
        super(text, errorMessage);
        this.inputValidator = new CharacterInputValidator();
    }

    public Character input() {
        System.out.println(this.getText());
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().trim();

            InputCharacterStatus inputCharacterStatus = inputValidator.validateLetterValue(answer);

            if (inputCharacterStatus.equals(InputCharacterStatus.CORRECT_CHARACTER)) {
                return answer.charAt(0);
            }

            System.out.println(inputCharacterStatus.getValue());
        }
    }


}
