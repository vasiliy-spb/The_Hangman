package org.game.view.ui;

public class IntegerInputValidator implements Validator {
    @Override
    public ValidationStatus validate(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return IntegerValidationStatus.EMPTY_VALUE;
        }
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                return IntegerValidationStatus.TOO_SMALL_NUMBER;
            }
        } catch (NumberFormatException nfe) {
            return IntegerValidationStatus.NOT_A_NUMBER;
        }
        if (input.length() > 1) {
            return IntegerValidationStatus.HAS_LEADING_ZERO;
        }
        return IntegerValidationStatus.CORRECT_NUMBER;
    }

    public ValidationStatus validate(String input, Integer num) {
        input = input.trim();
        if (input.length() == 0) {
            return IntegerValidationStatus.EMPTY_VALUE;
        }
        try {
            int number = Integer.parseInt(input);
            if (number < 1) {
                return IntegerValidationStatus.TOO_SMALL_NUMBER;
            }
            if (number > num) {
                return IntegerValidationStatus.TOO_BIG_NUMBER;
            }
        } catch (NumberFormatException nfe) {
            return IntegerValidationStatus.NOT_A_NUMBER;
        }
        if (input.length() > 1) {
            return IntegerValidationStatus.HAS_LEADING_ZERO;
        }
        return IntegerValidationStatus.CORRECT_NUMBER;
    }
}
