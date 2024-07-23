package org.game;

import org.game.constants.InputCharacterStatus;

import java.util.Set;

public class CharacterInputValidator {
    private static final Set<Character> VALID_CHARACTERS = Set.of(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
    );

    public InputCharacterStatus validateLetterValue(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return InputCharacterStatus.EMPTY_CHARACTER;
        }
        if (input.length() > 1) {
            return InputCharacterStatus.TOO_MUCH_CHARACTERS;
        }
        char letterValue = Character.toUpperCase(input.charAt(0));
        if (!Character.isLetter(letterValue)) {
            return InputCharacterStatus.CHARACTER_NOT_LETTER;
        }
        if (!VALID_CHARACTERS.contains(letterValue)) {
            return InputCharacterStatus.WRONG_LOCALE_CHARACTER;
        }
        return InputCharacterStatus.CORRECT_CHARACTER;
    }
}
