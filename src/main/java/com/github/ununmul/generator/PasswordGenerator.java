package com.github.ununmul.generator;

interface PasswordGenerator {

    String generate (int length);

    GeneratorType getType();
}
