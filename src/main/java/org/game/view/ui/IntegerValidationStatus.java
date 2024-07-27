package org.game.view.ui;

public enum IntegerValidationStatus implements ValidationStatus{
    CORRECT_NUMBER (""),
    TOO_SMALL_NUMBER ("Такого варианта не существует"),
    TOO_BIG_NUMBER ("Такого варианта нет"),
    NOT_A_NUMBER ("Введите ответ числом"),
    EMPTY_VALUE ("Выберите один из вариантов"),
    HAS_LEADING_ZERO("Введите число без лидирующих нулей");
    private final String statusMessage;
    IntegerValidationStatus(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
