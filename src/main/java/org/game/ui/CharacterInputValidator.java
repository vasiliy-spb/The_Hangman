package org.game.ui;

import java.util.Set;

public class CharacterInputValidator implements Validator{
    private static final Set<Character> VALID_CHARACTERS = Set.of(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    );

    @Override
    public CharacterValidationStatus validate(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return CharacterValidationStatus.EMPTY_CHARACTER;
        }
        if (input.length() > 1) {
            return CharacterValidationStatus.TOO_MUCH_CHARACTERS;
        }
        char letterValue = Character.toUpperCase(input.charAt(0));
        if (!Character.isLetter(letterValue)) {
            return CharacterValidationStatus.CHARACTER_NOT_LETTER;
        }
        if (!VALID_CHARACTERS.contains(letterValue)) {
            return CharacterValidationStatus.WRONG_LOCALE_CHARACTER;
        }
        return CharacterValidationStatus.CORRECT_CHARACTER;
    }
}
