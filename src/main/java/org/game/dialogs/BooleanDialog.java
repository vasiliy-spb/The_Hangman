package org.game.dialogs;

import org.game.NumberInputValidator;
import org.game.constants.InputNumberStatus;

import java.util.List;

public class BooleanDialog extends Dialog<Boolean> {
    List<String> keys;
    public BooleanDialog(InputReader reader, OutputWriter writer, String text, String errorMessage, String yesKey, String noKey) {
        super(reader, writer, text, errorMessage);
        this.keys = List.of(yesKey, noKey);
    }

    @Override
    public Boolean input() {
        writer.writeLine(this.getText());
        for (int i = 0; i < keys.size(); i++) {
            writer.writeString(String.format("%d — %s\n", i + 1, keys.get(i)));
        }
        while (true) {
            String answer = reader.readOneLine().trim();
            NumberInputValidator numberValidator = new NumberInputValidator();
            InputNumberStatus inputNumberStatus = numberValidator.validateIntegerValue(answer, keys.size());
            if (inputNumberStatus.equals(InputNumberStatus.CORRECT_NUMBER)) {
                return Integer.parseInt(answer) == 1;
            }
            writer.writeLine(inputNumberStatus.getValue());
        }
    }
}
