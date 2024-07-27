package org.game.view.ui;

import org.game.view.io.InputReader;
import org.game.view.io.OutputWriter;

import java.util.List;

public class BooleanDialog extends Dialog<Boolean> {
    private final List<String> keys;
    public BooleanDialog(InputReader reader, OutputWriter writer, String text, Validator validator, String yesKey, String noKey) {
        super(reader, writer, text, validator);
        this.keys = List.of(yesKey, noKey);
    }

    @Override
    public Boolean getInput() {
        writer.writeString(this.getText());
        writer.writeString(" (");
        for (int i = 0; i < keys.size(); i++) {
            writer.writeString(keys.get(i));
            if (i < keys.size() - 1) {
                writer.writeString("/");
            }
        }
        writer.writeLine("):");
        while (true) {
            String answer = reader.readOneLine().trim();
            ValidationStatus validationStatus = validator.validate(answer);
            if (validationStatus.equals(BooleanValidationStatus.TRUE_ANSWER)) {
                return true;
            }
            if (validationStatus.equals(BooleanValidationStatus.FALSE_ANSWER)) {
                return false;
            }
            writer.writeLine(validationStatus.getStatusMessage());
        }
    }
}
