package com.github.ununmul.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PasswordGeneratorLettersTest {

    PasswordGeneratorLetters pass;

    @Before
    public void setup() {
        pass = new PasswordGeneratorLetters();
    }

    @Ignore
    @Test
    public void check10PasswordsLettersWith6Characters() {
        System.out.println("10 loso wych hasel wyglada tak:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Haslo " + (i + 1) + ":" + pass.generate(6));
        }

    }

    @Test
    public void ifPasswordHas100Characters() {
        Assert.assertEquals(100, pass.generate(100).length());
    }


}