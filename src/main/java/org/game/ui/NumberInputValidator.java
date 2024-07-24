package org.game.ui;

import org.game.model.InputNumberStatus;

public class NumberInputValidator {
    public InputNumberStatus validateIntegerValue(String input, int variantCount) {
        input = input.trim();
        if (input.length() == 0) {
            return InputNumberStatus.EMPTY_VALUE;
        }
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                return InputNumberStatus.TOO_SMALL_NUMBER;
            }
            if (number > variantCount) {
                return InputNumberStatus.TOO_BIG_NUMBER;
            }
        } catch (NumberFormatException nfe) {
            return InputNumberStatus.NOT_A_NUMBER;
        }
        if (input.length() > 1) {
            return InputNumberStatus.HAS_LEADING_ZERO;
        }
        return InputNumberStatus.CORRECT_NUMBER;
    }
}
