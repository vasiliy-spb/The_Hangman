package org.game.ui;

import org.game.io.InputReader;
import org.game.io.OutputWriter;

import java.util.List;

public class IntegerDialog extends Dialog<Integer> {
    private final List<String> keys;

    public IntegerDialog(InputReader reader, OutputWriter writer, String text, Validator validator, String yesKey, String noKey) {
        super(reader, writer, text, validator);
        this.keys = List.of(yesKey, noKey);
    }

    public IntegerDialog(InputReader reader, OutputWriter writer, String text, Validator validator, List<String> keys) {
        super(reader, writer, text, validator);
        this.keys = keys;
    }

    @Override
    public Integer getInput() {
        writer.writeLine(this.getText());
        for (int i = 0; i < keys.size(); i++) {
            writer.writeString(String.format("%d — %s\n", i + 1, keys.get(i)));
        }
        while (true) {
            String answer = reader.readOneLine().trim();
            ValidationStatus validationStatus;
            if (validator instanceof IntegerInputValidator) {
                validationStatus = ((IntegerInputValidator) validator).validate(answer, keys.size());
            } else {
                validationStatus = validator.validate(answer);
            }
            if (validationStatus.equals(IntegerValidationStatus.CORRECT_NUMBER)) {
                return Integer.parseInt(answer) % keys.size();
            }
            writer.writeLine(validationStatus.getStatusMessage());
        }
    }
}
