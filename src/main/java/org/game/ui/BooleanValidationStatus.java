package org.game.ui;

public enum BooleanValidationStatus implements ValidationStatus {
    TRUE_ANSWER ("Да"),
    FALSE_ANSWER ("Нет"),
    WRONG_LOCALE ("Принамается ответ только на русском языке"),
    INCORRECT_ANSWER ("Такого варианта нет"),
    NOT_A_LETTER ("Введите ответ словом"),
    EMPTY_VALUE ("Выберите один из вариантов");
    private final String statusMessage;
    BooleanValidationStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
