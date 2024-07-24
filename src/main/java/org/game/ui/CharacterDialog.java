package org.game.ui;

import org.game.model.InputCharacterStatus;
import org.game.io.InputReader;
import org.game.io.OutputWriter;

public class CharacterDialog extends Dialog<Character> {
    private final CharacterInputValidator inputValidator;
    public CharacterDialog(InputReader reader, OutputWriter writer, String text, String errorMessage) {
        super(reader, writer, text, errorMessage);
        this.inputValidator = new CharacterInputValidator();
    }

    public Character getInput() {
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
