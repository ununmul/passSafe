package com.github.ununmul.model;

import com.github.ununmul.generator.GeneratorType;
import com.github.ununmul.generator.PasswordGeneratorFacade;

public class PasswordFacade {

    private PasswordGeneratorFacade passwordGeneratorFacade;

    public PasswordFacade () {
        this.passwordGeneratorFacade = new PasswordGeneratorFacade();
    }

    public PasswordEntry generatePassword(String website, String login, GeneratorType strategy, int length) {
        String password = passwordGeneratorFacade.getPassword(length, strategy);
        return new PasswordEntry(website, password, login);
    }
}
