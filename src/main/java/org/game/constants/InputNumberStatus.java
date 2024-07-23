package org.game.constants;

public enum InputNumberStatus {
    CORRECT_NUMBER (""),
    TOO_SMALL_NUMBER ("Такого варианта не существует"),
    TOO_BIG_NUMBER ("Такого варианта нет"),
    NOT_A_NUMBER ("Введите ответ числом"),
    EMPTY_VALUE ("Выберите один из вариантов");
    private final String value;
    InputNumberStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
