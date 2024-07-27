package org.game.ui;

import org.game.io.InputReader;
import org.game.io.OutputWriter;

public class CharacterDialog extends Dialog<Character> {
    public CharacterDialog(InputReader reader, OutputWriter writer, String text, Validator validator) {
        super(reader, writer, text, validator);
    }

    public Character getInput() {
        writer.writeLine(this.getText());
        while (true) {
            String answer = reader.readOneLine().trim();

            ValidationStatus validationStatus = validator.validate(answer);
            if (validationStatus.equals(CharacterValidationStatus.CORRECT_CHARACTER)) {
                return answer.charAt(0);
            }

            writer.writeLine(validationStatus.getStatusMessage());
        }
    }
}
