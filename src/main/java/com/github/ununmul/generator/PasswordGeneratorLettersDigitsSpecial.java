package com.github.ununmul.generator;

import java.util.Random;

class PasswordGeneratorLettersDigitsSpecial implements PasswordGenerator {

    @Override
    public String generate (int length) {
        Random random = new Random();
        String chars = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ!@%?#<>[]{}+=";
        String pass = "";

        for (int i = 0; i < length; i++) {
            pass = pass + chars.charAt(random.nextInt(chars.length()));
        }
        return pass;
    }

    @Override
    public GeneratorType getType() {
        return GeneratorType.LETTERS_DIGITS_SPECIAL;
    }
}
