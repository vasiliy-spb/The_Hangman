package org.game.dialogs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringIgnoreCaseDialog extends Dialog<String> {
    private List<String> keys;
    public StringIgnoreCaseDialog(String text, String wrongMessage, String yesKey, String noKey) {
        super(text, wrongMessage);
        this.keys = new ArrayList<>();
        this.keys.add(yesKey);
        this.keys.add(noKey);
    }
    public StringIgnoreCaseDialog(String text, String wrongMessage, List<String> keys) {
        super(text, wrongMessage);
        this.keys = keys;
    }

    @Override
    public String input() {
        System.out.print(this.getText());
        System.out.print("(");
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i));
            if (i < keys.size() - 1) {
                System.out.print("/");
            }
        }
        System.out.println("):");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().trim();
            for (String key : keys) {
                if (answer.equalsIgnoreCase(key)) {
                    return key;
                }
            }
            System.out.println(this.getErrorMessage());
        }
    }
}
