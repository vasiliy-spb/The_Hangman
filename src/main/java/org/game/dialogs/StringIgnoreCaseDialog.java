package org.game.dialogs;

import java.util.ArrayList;
import java.util.List;

public class StringIgnoreCaseDialog extends Dialog<String> {
    private final List<String> keys;
    public StringIgnoreCaseDialog(InputReader reader, OutputWriter writer, String text, String wrongMessage, String yesKey, String noKey) {
        super(reader, writer, text, wrongMessage);
        this.keys = new ArrayList<>();
        this.keys.add(yesKey);
        this.keys.add(noKey);
    }
    public StringIgnoreCaseDialog(InputReader reader, OutputWriter writer, String text, String wrongMessage, List<String> keys) {
        super(reader, writer, text, wrongMessage);
        this.keys = keys;
    }

    @Override
    public String input() {
        writer.writeString(this.getText());
        writer.writeString("(");
        for (int i = 0; i < keys.size(); i++) {
            writer.writeString(keys.get(i));
            if (i < keys.size() - 1) {
                writer.writeString("/");
            }
        }
        writer.writeLine("):");
        while (true) {
            String answer = reader.readOneLine().trim();
            for (String key : keys) {
                if (answer.equalsIgnoreCase(key)) {
                    return key;
                }
            }
            writer.writeLine(this.getErrorMessage());
        }
    }
}