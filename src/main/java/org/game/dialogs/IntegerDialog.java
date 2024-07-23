package org.game.dialogs;

import org.game.NumberInputValidator;
import org.game.constants.InputNumberStatus;

import java.util.List;
import java.util.Scanner;

public class IntegerDialog extends Dialog<Integer> {
    private List<String> keys;

    public IntegerDialog(String text, String errorMessage, String yesKey, String noKey) {
        super(text, errorMessage);
        this.keys = List.of(yesKey, noKey);
    }

    public IntegerDialog(String text, String errorMessage, List<String> keys) {
        super(text, errorMessage);
        this.keys = keys;
    }

    @Override
    public Integer input() {
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
                return Integer.parseInt(answer);
            }
            System.out.println(inputNumberStatus.getValue());

//            try {
//                int numAns = Integer.parseInt(answer);
//                if (numAns > 0 && numAns <= this.keys.size()) {
//                    return numAns;
//                }
//                System.out.println(this.getErrorMessage());
//            } catch (NumberFormatException nfe) {
//                System.out.println(this.getErrorMessage());
//            }

        }
    }
}
