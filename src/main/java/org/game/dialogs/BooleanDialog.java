package org.game.dialogs;

import org.game.NumberInputValidator;
import org.game.constants.InputNumberStatus;

import java.util.List;
import java.util.Scanner;

public class BooleanDialog extends Dialog<Boolean> {
    List<String> keys;
    public BooleanDialog(String text, String errorMessage, String yesKey, String noKey) {
        super(text, errorMessage);
        this.keys = List.of(yesKey, noKey);
    }

    @Override
    public Boolean input() {
        System.out.println(this.getText());
        for (int i = 0; i < keys.size(); i++) {
            System.out.printf("%d — %s\n", i + 1, keys.get(i));
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().trim();
            NumberInputValidator numberValidator = new NumberInputValidator();
            InputNumberStatus inputNumberStatus = numberValidator.validateIntegerValue(answer, keys.size());
            if (inputNumberStatus.equals(InputNumberStatus.CORRECT_NUMBER)) {
                return Integer.parseInt(answer) == 1;
            }
            System.out.println(inputNumberStatus.getValue());
//            try {
//                int numAns = Integer.parseInt(answer);
//                if (numAns == 1 || numAns == 2) {
//                    return numAns == 1;
//                }
//                System.out.println(this.getErrorMessage());
//            } catch (NumberFormatException nfe) {
//                System.out.println(this.getErrorMessage());
//            }
        }
    }
}
