package org.game.dialogs;

import org.game.NumberInputValidator;
import org.game.constants.InputNumberStatus;

import java.util.List;

public class IntegerDialog extends Dialog<Integer> {
    private List<String> keys;

    public IntegerDialog(InputReader reader, OutputWriter writer, String text, String errorMessage, String yesKey, String noKey) {
        super(reader, writer, text, errorMessage);
        this.keys = List.of(yesKey, noKey);
    }

    public IntegerDialog(InputReader reader, OutputWriter writer, String text, String errorMessage, List<String> keys) {
        super(reader, writer, text, errorMessage);
        this.keys = keys;
    }

    @Override
    public Integer input() {
        writer.writeLine(this.getText());
        for (int i = 0; i < keys.size(); i++) {
            writer.writeString(String.format("%d — %s\n", i + 1, keys.get(i)));
        }
        while (true) {
            String answer = reader.readOneLine().trim();

            NumberInputValidator numberValidator = new NumberInputValidator();
            InputNumberStatus inputNumberStatus = numberValidator.validateIntegerValue(answer, keys.size());
            if (inputNumberStatus.equals(InputNumberStatus.CORRECT_NUMBER)) {
                return Integer.parseInt(answer);
            }
            writer.writeLine(inputNumberStatus.getValue());
        }
    }
}
