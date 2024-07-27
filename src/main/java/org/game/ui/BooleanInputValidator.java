package org.game.ui;

public class BooleanInputValidator implements Validator {
    @Override
    public BooleanValidationStatus validate(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return BooleanValidationStatus.EMPTY_VALUE;
        }
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                return BooleanValidationStatus.NOT_A_LETTER;
            }
        }
        if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
            return BooleanValidationStatus.WRONG_LOCALE;
        }
        if (input.equalsIgnoreCase(BooleanValidationStatus.TRUE_ANSWER.getStatusMessage())) {
            return BooleanValidationStatus.TRUE_ANSWER;
        }
        if (input.equalsIgnoreCase(BooleanValidationStatus.FALSE_ANSWER.getStatusMessage())) {
            return BooleanValidationStatus.FALSE_ANSWER;
        }
        return BooleanValidationStatus.INCORRECT_ANSWER;
    }
}
