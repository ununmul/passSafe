package com.github.ununmul.generator;

import static com.github.ununmul.generator.GeneratorType.LETTERS;
import static com.github.ununmul.generator.GeneratorType.LETTERS_DIGITS;
import static com.github.ununmul.generator.GeneratorType.LETTERS_DIGITS_SPECIAL;

public class PasswordGeneratorFactory {

    PasswordGenerator getGenerator(GeneratorType type) {

        if (type == LETTERS ) {
            return new PasswordGeneratorLetters();
        }

        if (type==LETTERS_DIGITS) {
            return new PasswordGeneratorLettersDigits();
        }

        if (type==LETTERS_DIGITS_SPECIAL) {
            return new PasswordGeneratorLettersDigitsSpecial();
        }

        throw new PasswordGeneratorException("No such generator");
    }
}
