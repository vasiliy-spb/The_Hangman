package org.game.dialogs;

import org.game.CharacterInputValidator;
import org.game.constants.InputCharacterStatus;

public class CharacterDialog extends Dialog<Character> {
    CharacterInputValidator inputValidator;
    public CharacterDialog(InputReader reader, OutputWriter writer, String text, String errorMessage) {
        super(reader, writer, text, errorMessage);
        this.inputValidator = new CharacterInputValidator();
    }

    public Character input() {
        writer.writeLine(this.getText());
        while (true) {
            String answer = reader.readOneLine().trim();

            InputCharacterStatus inputCharacterStatus = inputValidator.validateLetterValue(answer);

            if (inputCharacterStatus.equals(InputCharacterStatus.CORRECT_CHARACTER)) {
                return answer.charAt(0);
            }

            writer.writeLine(inputCharacterStatus.getValue());
        }
    }


}
